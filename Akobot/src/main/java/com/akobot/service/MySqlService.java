package com.akobot.service;

import com.akobot.domain.AnswerDTO;
import com.akobot.domain.AskDTO;
import com.akobot.domain.BoardVO;

import java.util.ArrayList;

public interface MySqlService {
    public void generateDBBackUpFile() throws Exception;

    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception;

    public void add(BoardVO board) throws Exception;

    public long getBno() throws Exception;
}
