package com.akobot.service;

import com.akobot.domain.AnswerDTO;
import com.akobot.domain.AskDTO;

import java.util.ArrayList;

public interface MySqlService {
    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception;
}
