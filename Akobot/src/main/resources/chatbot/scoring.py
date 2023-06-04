# training with 'simple.CSV'
import pandas as pd
import numpy as np
from soynlp.utils import DoublespaceLineCorpus
from soynlp.word import WordExtractor
import csv

# load CSV in dataframe type
training=pd.read_csv("simple.csv", encoding="utf-8")

# write the dataframe['content'] into txt file
f = open("training.txt", 'wt', encoding='utf-8')
for i in range(0, len(training)):
    data = training['content'].values[i]
    print(data)
    f.write(data+'\n')
f.close()

# counting txt file's line number
corpus = DoublespaceLineCorpus("training.txt")

# corpus training
word_extractor = WordExtractor()
word_extractor.train(corpus) # "training was done. used memory 0.120 Gb 0.120 Gb" 출력됨
word_score_table = word_extractor.extract() # 이 코드가 연산 3가지 cohesion probabilities, branching entropies, accessor variety 출력함..
scores = {word:score.cohesion_forward for word, score in word_score_table.items()} 
print(scores)

# training의 최종 결과물인 scores (type:dictionary)
'''
scores.CSV으로 scores 파싱하기
(혹은 scores.json으로 scores 파싱하기)
'''
with open("scores.csv", 'w', newline="", encoding="utf-8") as file:
    writer = csv.writer(file)
    for k, v in scores.items():
        writer.writerow([k, v])