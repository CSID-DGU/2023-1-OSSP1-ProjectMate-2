# extracting keywords from the input sentence of user
import pandas as pd
from soynlp.utils import DoublespaceLineCorpus
from soynlp.word import WordExtractor
from soynlp.tokenizer import MaxScoreTokenizer
import json

# load data for training..*will be modified with DB
training=pd.read_csv("simple.csv", encoding="utf-8")
training=pd.DataFrame(training['content'])

'''
#단락 구분하기
contents=[]
for i in training:
    i=' '.join(i.split())
    contents.append(i)
    training=pd.DataFrame(contents)
'''

# write .txt file
f = open("training.txt", 'wt', encoding='utf-8')
for i in range(0, 10):
    data = training.loc[i].to_string()
    f.write(data+'\n')
f.close()


'''
#load json (DB)
with open('C:\\test.json', 'r') as f:
    json_data = json.load(f)
print(json.dumps(json_data, indent="\t") )
'''

# counting txt file's line number
corpus = DoublespaceLineCorpus("training.txt")

# corpus training
word_extractor = WordExtractor()
word_extractor.train(corpus) # 여기에서 training was done. used memory 0.120 Gb 0.120 Gb 나온다.
word_score_table = word_extractor.extract() # 이 코드가 연산 3가지 cohesion probabilities, branching entropies, accessor variety 출력함..

# make scoring for tokenizing
scores = {word:score.cohesion_forward for word, score in word_score_table.items()}
maxscore_tokenizer = MaxScoreTokenizer(scores=scores)

# extracted keywords
keywords=[]
keywords=maxscore_tokenizer.tokenize("정시랑 논술전형 어때?") # 사용자 질문
print("사용자 입력>>","정시랑 논술전형 어때?\n")

