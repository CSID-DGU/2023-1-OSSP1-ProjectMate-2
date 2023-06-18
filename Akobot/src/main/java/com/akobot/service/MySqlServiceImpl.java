package com.akobot.service;

import com.akobot.Preprocessor;
import com.akobot.domain.*;
import com.akobot.domain.tables.*;
import com.akobot.repository.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.thymeleaf.util.StringUtils.substring;

@Slf4j
@Service
//@Transactional(readOnly = true)
@Transactional
@RequiredArgsConstructor
public class MySqlServiceImpl implements MySqlService {

    private final Preprocessor preprocessor = new Preprocessor();

    private final AskSolRepository askSolRepo;
    private final EtcRepository etcRepo;
    private final KsatRepository ksatRepo;
    private final EarlyAdmissionRepository earlyAdmissionRepo;
    private final TestRepository testRepo;

    @Override
    public void generateDBBackUpFile() throws Exception{
        List<EtcEntity> etcEntities = etcRepo.findAll();
        List<KsatEntity> ksatEntities = ksatRepo.findAll();
        List<EarlyAdmissionEntity> earlyAdmissionEntities = earlyAdmissionRepo.findAll();
        List<TestEntity> testEntities = testRepo.findAll();

        String rt = "{";
        for(EtcEntity etc : etcEntities){
            rt += "\"" + etc.getDname() + "\":";

            if(etc.getLevel() == 1) {
                String intent = etc.getPks().getDocument();
                String[] tmp = intent.split("_");
                rt += "[\"" + tmp[1] + "\",";
            }
            else{
                rt += "[\"" + etc.getPks().getDocument() + "\",";
            }
            rt += etc.getLevel() + "],";
        }
        for(KsatEntity ksat : ksatEntities) {
            rt += "\"" + ksat.getDname() + "\":";

            if(ksat.getLevel() == 1) {
                String intent = ksat.getPks().getDocument();
                String[] tmp = intent.split("_");
                rt += "[\"" + tmp[1] + "\",";
            }
            else{
                rt += "[\"" + ksat.getPks().getDocument() + "\",";
            }
            rt += ksat.getLevel() + "],";
        }
        for(EarlyAdmissionEntity earlyAdmission : earlyAdmissionEntities){
            rt += "\"" + earlyAdmission.getDname() + "\":";

            if(earlyAdmission.getLevel() == 1) {
                String intent = earlyAdmission.getPks().getDocument();
                String[] tmp = intent.split("_");
                rt += "[\"" + tmp[1] + "\",";
            }
            else{
                rt += "[\"" + earlyAdmission.getPks().getDocument() + "\",";
            }
            rt += earlyAdmission.getLevel() + "],";
        }
        int i = 0;
        for(TestEntity test : testEntities){
            rt += "\"" + test.getDname() + "\":";

            if(test.getLevel() == 1) {
                String intent = test.getPks().getDocument();
                String[] tmp = intent.split("_");
                rt += "[\"" + tmp[1] + "\",";
            }
            else{
                rt += "[\"" + test.getPks().getDocument() + "\",";
            }
            rt += test.getLevel() + "]";

            if(i < testEntities.size()-1)
                rt += ",";

            i++;
        }
        rt += "}";
        //rt = rt.replaceAll(System.getProperty("line.separator"),"");
        rt = rt.replaceAll("(\\r\\n|\\r|\\n|\\n\\r) ", "");
        log.info("출력 내용: " + rt);

        log.info("db.txt 파일 생성");
        String filePath = "Akobot/src/main/resources/chatbot/db.txt";

        File file = new File(filePath); // File객체 생성
        if(!file.exists()){ // 파일이 존재하지 않으면
            file.createNewFile(); // 신규생성
        }

        // BufferedWriter 생성
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, false));

        // 파일에 쓰기
        writer.write(rt);

        // 버퍼 및 스트림 뒷정리
        writer.flush(); // 버퍼의 남은 데이터를 모두 쓰기
        writer.close(); // 스트림 종료
    }

    @Override
    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception{
        //ArrayList<Intent> matchedIntents = new ArrayList<>();
        ArrayList<AnswerDTO> answers = new ArrayList<>();

        /**
         * Preprocesser가 완성되기 전까지는
         * 입력받은 string을 ','를 기준으로 tokenize 하여 intent 이름으로 인식한다.
         */
        //String [] intents = ask.getAsk().split(",");

        /**
         * Python 모듈을 사용하는 Preprocessor를 활용한 intent matching
         * Python 모듈에서 argument로 입력을 받는 것이 구현되지 않아 고정된 intent만 출력
         */
        log.info("ask.getAsk() -> " + ask.getAsk());
        List<String> intentsByPreprocessor = preprocessor.getMatchedIntents(ask.getAsk());

        for(String i : intentsByPreprocessor){
            log.info("Lines from Preprocessor -> " + i);
        }

        List<PreprocessorDTO> preDTOs = preprocessor.toArray(intentsByPreprocessor);
        for(PreprocessorDTO pd : preDTOs) {
            log.info("intents by PreprocessorDTO -> " + pd.toString());
        }

        String field = "";              // ex) competition, foreign, jungsi, ...
        String doc = "";                // ex) competition_susi, competition_jungsi, ...

        /**
         * 각각의 intent에 대한 답변을
         * AnswerDTO 형식으로 생성한다.
         */
        //for(String intent : intents) {
        for(PreprocessorDTO preDTO : preDTOs) {
            String intent = preDTO.getIntentName();

            String[] tmp = intent.split("_");
            if (tmp.length > 1) {
                field = tmp[0];
                doc = intent;
            }
            else{
                field = intent;
                doc = intent + "_" + intent;
            }

            IntentDTO intentDTO = new IntentDTO();

            if((intentDTO = etcRepo.findOne(11111, field, doc)) != null);
            else if((intentDTO = earlyAdmissionRepo.findOne(11111, field, doc)) != null);
            else if((intentDTO = ksatRepo.findOne(11111, field, doc)) != null);
            else if((intentDTO = testRepo.findOne(11111, field, doc)) != null);

            ArrayList<String> tmpStr = new ArrayList<>();

            if(intentDTO != null) {
                log.info(intentDTO.getClass() + " -> " + intentDTO);

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
                }
            }
            else {
                log.info("intentDTO.getClass() -> null");

                log.info("fall-back occurred");
                tmpStr.add("음..잘 모르겠어요");
                tmpStr.add("아래 링크로 문의 주세요! 이메일로 답변해드립니다!");
                tmpStr.add("localhost:8090/ask");
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
