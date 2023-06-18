package com.akobot;

import com.akobot.domain.tables.AskSolEntity;
import com.akobot.domain.tables.PushLogAskSolPK;
import com.akobot.repository.AskSolRepository;
import com.akobot.service.MySqlService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@Slf4j
class AkoApplicationTests {
	@Autowired
	MySqlService mySqlService;
	@Autowired
	AskSolRepository askSolRepository;

	@Test
	public void 질문추가() throws Exception{
		long bno = mySqlService.getBno();

		PushLogAskSolPK askSolPK = new PushLogAskSolPK();
		askSolPK.setSchool_key(11111);
		askSolPK.setField("TBL_ASK");
		askSolPK.setBno(++bno);

		AskSolEntity askSol = AskSolEntity.builder()
				.pks(askSolPK)
				.question(ZonedDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
						+ " question " + bno)
				.answer(null)
				.email("minje@example.com")
				.name("박민제")
				.askDate(null)
				.answerDate(null)
				.isAnswered(0)
				.build();

		log.info(askSolRepository.save(askSol).toString());
	}

	@Test
	public void preprocessor() throws IOException, InterruptedException {
		Preprocessor preprocessor = new Preprocessor();
		preprocessor.getMatchedIntents("수시 논술 알려줘");
	}

}
