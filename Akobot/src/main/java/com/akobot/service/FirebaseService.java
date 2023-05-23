package com.akobot.service;

import com.akobot.domain.AnswerDTO;
import com.akobot.domain.AskDTO;
import com.akobot.domain.IntentDTO;
import com.google.cloud.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public interface FirebaseService {

    public ArrayList<AnswerDTO> getAnswer(AskDTO ask) throws Exception;
}
