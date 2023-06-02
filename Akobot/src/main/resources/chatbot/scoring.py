# training with 'simple.CSV'
import pandas as pd
from soynlp.utils import DoublespaceLineCorpus
from soynlp.word import WordExtractor

# load data for training. (training은 'simple.CSV'의 질문목록 사용)
training=pd.read_csv("simple.csv", encoding="utf-8")
training=pd.DataFrame(training['content'])


# write .txt file
f = open("training.txt", 'wt', encoding='utf-8')
for i in range(0, 10):
    data = training.loc[i].to_string()
    f.write(data+'\n')
f.close()


# counting txt file's line number
corpus = DoublespaceLineCorpus("training.txt")

# corpus training
word_extractor = WordExtractor()
word_extractor.train(corpus) # "training was done. used memory 0.120 Gb 0.120 Gb" 출력됨
word_score_table = word_extractor.extract() # 이 코드가 연산 3가지 cohesion probabilities, branching entropies, accessor variety 출력함..

# training의 최종 결과물인 word_score_table (type:dictionary)

'''
score_table.CSV으로 word_score_table 파싱하기
(혹은 score_table.json으로 word_score_table 파싱하기)
'''