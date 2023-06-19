package com.akobot;

import com.akobot.domain.PreprocessorDTO;
import com.akobot.domain.tables.AskSolEntity;
import com.akobot.domain.tables.PushLogAskSolPK;
import com.akobot.repository.AskSolRepository;
import com.akobot.service.MySqlService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

	@Test
	public void intentMatchingTest() throws IOException, InterruptedException {
		int pass = 0, fail = 0,
				fallback_tp = 0, fallback_fp = 0, fallback_tn = 0, fallback_fn = 0;

		Preprocessor preprocessor = new Preprocessor();

		List<String> questionList = new ArrayList<>();
		List<ArrayList<String>> intentsList = new ArrayList<>();
		File csv = new File("C:\\Users\\win11\\source\\repos\\2023-1-OPPS1-ProjectMate-2\\dataset.csv");
		BufferedReader br = null;
		String line = "";

		try{
			br = new BufferedReader(new FileReader(csv));
			while((line = br.readLine()) != null){
				log.info(line);
				String[] lineArr = line.split(",");
				questionList.add(lineArr[0]);

				ArrayList<String> intents = new ArrayList<>();
				for(int i = 1; i < lineArr.length; i++)
					intents.add(lineArr[i]);
				intentsList.add(intents);
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try{
				if(br != null){
					br.close();
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		int listSize = 0;
		if(questionList.size() == intentsList.size())
			listSize = questionList.size();

		for(int i = 0; i < listSize; i++) {

			log.info("question -> " + questionList.get(i));
			List<String> intentsByPreprocessor = preprocessor.getMatchedIntents(questionList.get(i));

			for (String s : intentsByPreprocessor) {
				log.info("Lines from Preprocessor -> " + s);
			}

			List<PreprocessorDTO> preDTOs = preprocessor.toArray(intentsByPreprocessor);
			ArrayList<String> matchedIntents = new ArrayList<>();
			for(PreprocessorDTO p : preDTOs){
				matchedIntents.add(p.getIntentName());
			}
			Collections.sort(matchedIntents);
			Collections.sort(intentsList.get(i));
			log.info("matchedIntents -> " + matchedIntents);
			log.info("intentsList.get(i) -> " + intentsList.get(i));

			if(matchedIntents.size() == intentsList.get(i).size()) {
				for (int j = 0; j < matchedIntents.size(); j++) {
					String matchedIntent = matchedIntents.get(j);
					String intendedIntent = intentsList.get(i).get(j);
					log.info("PreprocessorDTO.getIntentName() ->" + matchedIntent);
					log.info("intentsList.get(i). ->" + intendedIntent);
					if (matchedIntent.equals(intendedIntent)) {
						pass++;
						if (intendedIntent.equals("fallback_default")) {
							// fallback이 매칭되었고 원래 fallback인 경우
							fallback_tp++;
						}
					} else {
						fail++;
						if (matchedIntent.equals("fallback_default")) {
							// fallback이 매칭되었는데 원래 fallback이 아닌경우
							fallback_fp++;
						}
						if (intendedIntent.equals("fallback_default")) {
							// 원래 fallback인데 매칭인 안된경우
							fallback_fn++;
						}
					}
				}
			}
			else{
				fail++;
				if(intentsList.get(i).contains("fallback_default"))
					fallback_fn++;
			}
			log.info("pass = " + pass + " / fail = " + fail);
		}

		try {
			File file = new File("C:\\Users\\win11\\source\\repos\\2023-1-OPPS1-ProjectMate-2\\TestResult.txt");

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fw);

			writer.write("***pass or fail***\n");
			writer.write("pass: " + pass + "\n");
			writer.write("fail: " + fail);

			writer.write("\n***about fallback***\n");
			writer.write("True Positive: " + fallback_tp + "\n");
			writer.write("False Positive: " + fallback_fp + "\n");
			writer.write("False Negative: " + fallback_fn + "\n");

			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
