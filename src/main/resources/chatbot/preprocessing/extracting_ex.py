#libraries
import pandas as pd
import urllib.request
from soynlp import DoublespaceLineCorpus
from soynlp.word import WordExtractor
from soynlp.tokenizer import MaxScoreTokenizer
from soynlp.tokenizer import LTokenizer

df=pd.read_csv("simple.CSV", encoding="euc-kr")

#질문 관련 컬럼만 로드
df=df['content']

#단락 구분 제거
contents=[]
for i in df:
    i=' '.join(i.split())
    contents.append(i)
    df=pd.DataFrame(contents)

#텍스트 파일 작성
f = open("df.txt", 'wt', encoding='utf-8')
for i in  range(0, 29):
    data = df.loc[i].to_string()
    f.write(data+'\n')
f.close()


#텍스트 파일로부터 각 라인 분리 후 개수 출력
corpus = DoublespaceLineCorpus("df.txt")
print("text file's line number is ", len(corpus))

#corpus training
word_extractor = WordExtractor()
word_extractor.train(corpus)
word_score_table = word_extractor.extract()


scores = {word:score.cohesion_forward for word, score in word_score_table.items()}
l_tokenizer = LTokenizer(scores=scores)
print(l_tokenizer.tokenize("정시 전형을 자세히 알려줄래?", flatten=False)) #must space
#l_tokenizer.tokenize("정시전형을자세히알려줄래?", flatten=False)


maxscore_tokenizer = MaxScoreTokenizer(scores=scores)
#maxscore_tokenizer.tokenize("정시 전형을 자세히 알려줄래?")
print(maxscore_tokenizer.tokenize("정시전형자세히알려줄래?"))