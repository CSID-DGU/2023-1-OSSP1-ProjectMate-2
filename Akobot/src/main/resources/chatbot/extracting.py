# extracting keywords from the input sentence of user
import pandas as pd
from soynlp.tokenizer import MaxScoreTokenizer
import scoring # scoring.py import (제거 예정)

# load 'word_scoring_table'이 저장된 CSV


# convert CSV file to dict.


# make scoring for tokenizing
scores = {word:score.cohesion_forward for word, score in scoring.word_score_table.items()} # word_score_table 변경 예정
maxscore_tokenizer = MaxScoreTokenizer(scores=scores)

# extracting의 최종 결과물 extracted keywords
keywords=[]
keywords=maxscore_tokenizer.tokenize("정시랑 논술전형 어때?") # 사용자 질문은 agvs형태로 콘솔로 입력받기

# 사용자 입력 확인용 (제거 예정)
print()
print("사용자 입력>>","정시랑 논술전형 어때?")

