package com.akobot.service;

import com.akobot.Preprocessor;
import com.akobot.domain.*;
import com.akobot.domain.tables.AskSolEntity;
import com.akobot.domain.tables.PushLogAskSolPK;
import com.akobot.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MySqlServiceImpl implements MySqlService {

    private final Preprocessor preprocessor = new Preprocessor();

    private final AskSolRepository askSolRepo;
    private final EtcRepository etcRepo;
    private final JungsiRepository jungsiRepo;
    private final SusiRepository susiRepo;
    private final TestRepository testRepo;

    @Override
    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception{
        //ArrayList<Intent> matchedIntents = new ArrayList<>();
        ArrayList<AnswerDTO> answers = new ArrayList<>();

        /**
         * Python 모듈을 사용하는 Preprocessor를 활용한 intent matching
         * Python 모듈에서 argument로 입력을 받는 것이 구현되지 않아 고정된 intent만 출력
         */
        List<String> intentsByPreprocessor = preprocessor.getMatchedIntents(ask.getAsk());

        for(String i : intentsByPreprocessor){
            log.info("Lines from Preprocessor -> " + i);
        }

        List<PreprocessorDTO> preDTOs = preprocessor.toArray(intentsByPreprocessor);
        for(PreprocessorDTO pd : preDTOs) {
            log.info("intents by PreprocessorDTO -> " + pd.toString());
        }

        /**
         * Preprocesser가 완성되기 전까지는
         * 입력받은 string을 ','를 기준으로 tokenize 하여 intent 이름으로 인식한다.
         */
        String [] intents = ask.getAsk().split(",");

        String field = "";              // ex) competition, foreign, jungsi, ...
        String doc = "";                // ex) competition_susi, competition_jungsi, ...

        /**
         * 각각의 intent에 대한 답변을
         * AnswerDTO 형식으로 생성한다.
         *
         * intentDTO 양식으로 프론트에 보낼 수도 있지만,
         * 우선은 이런식으로 한다.
         */
        for(String intent : intents) {
            String[] tmp = intent.split("_");
            if (tmp.length > 1) {
                field = tmp[0];
                doc = intent;
            }

            IntentDTO intentDTO = new IntentDTO();

            if((intentDTO = etcRepo.findOne(11111, field, doc)) != null);
            else if((intentDTO = susiRepo.findOne(11111, field, doc)) != null);
            else if((intentDTO = jungsiRepo.findOne(11111, field, doc)) != null);
            else if((intentDTO = testRepo.findOne(11111, field, doc)) != null);

            log.info(intentDTO.getClass() + " -> " + intentDTO);

            ArrayList<String> tmpStr = new ArrayList<>();
            if(!intentDTO.getPks().getDocument().equals("fallback_default")) {
                tmpStr.add(intentDTO.getMethod());
                tmpStr.add(intentDTO.getTarget());
                tmpStr.add(intentDTO.getContent());
                tmpStr.add(intentDTO.getCondition_text());
                tmpStr.add(intentDTO.getPoint());
                tmpStr.add(intentDTO.getTest());
                tmpStr.add(intentDTO.getElseData());
            }
            else{
                log.info("fall-back occurred");
                tmpStr.add("음..잘 모르겠어요");
                tmpStr.add("아래 링크로 문의 주세요! 이메일로 답변해드립니다!");
                tmpStr.add("localhost:8090/ask");

                answers.clear();
            }

            AnswerDTO answer = new AnswerDTO();
            answer.setSays(tmpStr);

            answers.add(answer);
        }

        log.info(answers.getClass() + " -> " + answers);

        return answers;
    }

    /* bno 읽어와 bno 갱신한 새 도큐먼트 DB에 삽입*/
    @Override
    public void add(@ModelAttribute BoardVO board) throws Exception {

        /* 마지막 bno을 읽어와 ++bno 값으로 새 도큐먼트를 DB에 삽입*/
        long bno = getBno();

        PushLogAskSolPK askSolPK = new PushLogAskSolPK();
        askSolPK.setSchool_key(11111);
        askSolPK.setField("TBL_ASK");
        askSolPK.setBno(++bno);

        AskSolEntity askSol = AskSolEntity.builder()
                .pks(askSolPK)
                .question(board.getQuestion())
                .answer(board.getAnswer())
                .email(board.getEmail())
                .name(board.getName())
                .askDate(null)
                .answerDate(null)
                .isAnswered(0)
                .build();

        log.info("Add Question: " + askSol.getClass() + " -> " + askSol.toString());

        log.info(askSolRepo.save(askSol).toString());
    }

    /* getBno */
    @Override
    public long getBno() throws Exception {
        return askSolRepo.maxBno();
    }
}
