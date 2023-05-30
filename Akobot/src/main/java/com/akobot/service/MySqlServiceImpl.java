package com.akobot.service;

import com.akobot.domain.*;
import com.akobot.domain.tables.EtcEntity;
import com.akobot.repository.EtcRepository;
import com.akobot.repository.JungsiRepository;
import com.akobot.repository.SusiRepository;
import com.akobot.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MySqlServiceImpl implements MySqlService {

    private final EtcRepository etcRepo;
    private final JungsiRepository jungsiRepo;
    private final SusiRepository susiRepo;
    private final TestRepository testRepo;

    @Override
    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception{
        //ArrayList<Intent> matchedIntents = new ArrayList<>();
        ArrayList<AnswerDTO> answers = new ArrayList<>();

        String field = "";              // ex) competition, foreign, jungsi, ...
        String doc = "";                // ex) competition_susi, competition_jungsi, ...

        /**
         * Preprocesser가 완성되기 전까지는
         * 입력받은 string을 ','를 기준으로 tokenize 하여 intent 이름으로 인식한다.
         */
        String [] intents = ask.getAsk().split(",");

        /**
         * 각각의 intent에 대한 답변을
         * AnswerDTO 형식으로 생성한다.
         *
         * intentDTO 양식으로 프론트에 보낼 수도 있지만,
         * 우선은 이런식으로 한다.
         */
        for(String intent : intents) {
            String[] tmp = intent.split("_");
            if (tmp.length != 0) {
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
            tmpStr.add(intentDTO.getMethod());
            tmpStr.add(intentDTO.getTarget());
            tmpStr.add(intentDTO.getContent());
            tmpStr.add(intentDTO.getCondition_text());
            tmpStr.add(intentDTO.getPoint());
            tmpStr.add(intentDTO.getTest());
            tmpStr.add(intentDTO.getElseData());

            AnswerDTO answer = new AnswerDTO();
            answer.setSays(tmpStr);

            answers.add(answer);
        }

        return answers;
    }
}
