# extracting keywords from the input sentence of user
import pandas as pd
from soynlp.tokenizer import MaxScoreTokenizer
import csv
#import os
#print(os.getcwd())

def extracKeywords(usr_input):
    # load 'scores.CSV' & convert CSV file to dict.
    scores = {}
    # 맞는 경로 
    # 임시!!!!!!! C:/Users/win11/source/repos/2023-1-OPPS1-ProjectMate-2/Akobot/src/main/resources/chatbot/scores.csv
    # 로컬에서는 그냥 scores.csv로 해야 에러나지 않는다
    with open("./Akobot/src/main/resources/chatbot/scores.csv",
    #with open("./src/main/resources/chatbot/scores.csv",
              'r', encoding="utf-8") as file:
        reader = csv.reader(file)
        for row in reader:
            scores[row[0]] = float(row[1])

    # scores바탕으로 토크나이저 생성
    maxscore_tokenizer = MaxScoreTokenizer(scores=scores)

    # extracting의 최종 결과물 extracted keywords (type:1D list)
    keywords=[]
    # keywords=maxscore_tokenizer.tokenize("정시랑 논술전형 어때?") # 사용자 질문은 agvs형태로 콘솔로 입력받는 것으로 변경예정
    keywords=maxscore_tokenizer.tokenize(usr_input)

    # 사용자 입력 확인용 (제거 예정)
    # print("사용자 입력>>","정시랑 논술전형 어때?")
    # rint("토크나이징 결과>>",keywords)

    return keywords