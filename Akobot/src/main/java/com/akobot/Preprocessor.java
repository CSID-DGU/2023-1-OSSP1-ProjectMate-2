package com.akobot;

import com.akobot.domain.PreprocessorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class Preprocessor {
    public List<String> getMatchedIntents(String usr_input) throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("python",
                "Akobot/src/main/resources/chatbot/intentmatching.py", usr_input);

        Process p = pb.start();

        p.waitFor();

        BufferedReader bfr = new BufferedReader(new InputStreamReader(p.getInputStream()));
        List<String> lines = new ArrayList<>();
        String line = "";

        while((line = bfr.readLine()) != null){
            lines.add(line);
        }

        return lines;
    }

    public List<PreprocessorDTO> toArray(List<String> linesFromPython){
        List<PreprocessorDTO> intents = new ArrayList<>();
        String intentName = "";
        String level = "";

        for(String l : linesFromPython){
            char[] c = l.toCharArray();
            int brackets = 0;

            for(int i = 0; i < c.length; ){
                if(c[i] == '['){
                    brackets++;
                    i++;
                }
                else if(c[i] == ']'){
                    brackets--;
                    i++;
                }
                else if(c[i] == '\'' && brackets == 2){
                    i++;

                    intentName = "";
                    level = "";

                    PreprocessorDTO tmpDTO = new PreprocessorDTO();

                    while(c[i] != '\''){
                        intentName += c[i];
                        i++;
                    }
                    log.info(intentName);

                    if(c[i] == '\'') i++;

                    if(c[i] == ',') i++;

                    if(c[i] == ' ') i++;

                    while(c[i] != ']'){
                        level += c[i];
                        i++;
                    }
                    log.info(level);

                    tmpDTO.setIntentName(intentName);
                    tmpDTO.setLevel(level);

                    intents.add(tmpDTO);
                }
                else i++;
            }
        }

        return intents;
    }
}
