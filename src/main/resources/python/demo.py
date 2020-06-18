# coding=utf-8
from snownlp import SnowNLP

# a = np.arange(12).reshape(3, 4)
# print(a)
# print("春江花月夜")

s = SnowNLP("我今天也非常开心的")
# # 分词
print(s.words)

# s = '\xe6\x88\x91\xe4\xbb\x8a\xe5\xa4\xa9\xe4\xb9\x9f\xe9\x9d\x9e\xe5\xb8\xb8\xe5\xbc\x80\xe5\xbf\x83\xe7\x9a\x84'
# ss = s.encode('raw_unicode_escape')
# print(ss)
# sss = ss.decode()
# print(sss)
