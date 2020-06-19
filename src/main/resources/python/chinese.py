# coding=utf-8
from snownlp import SnowNLP

s = SnowNLP("春江花月夜")
# 分词
print(s.words)
# 词性标注
tags = [x for x in s.tags]
print(tags)
# 断句
print(s.sentences)
# 拼音
print(s.pinyin)

# 情绪判断，返回值为正面情绪的概率，越接近1表示正面情绪，越接近0表示负面情绪
text1 = '美人'
text2 = '愿情'
s1 = SnowNLP(text1)
s2 = SnowNLP(text2)
print(text1, s1.sentiments)
print(text2, s2.sentiments)

# 关键字抽取
text3 = '春江潮水连海平，海上明月共潮生。\
    滟滟随波千万里，何处春江无月明？\
    江流宛转绕芳甸，月照花林皆似霰。\
    空里流霜不觉飞，汀上白沙看不见。\
    江天一色无纤尘，皎皎空中孤月轮。\
    江畔何人初见月，江月何年初照人？\
    人生代代无穷已，江月年年只相似。\
    不知江月待何人？但见长江送流水。\
    白云一片去悠悠，青枫浦上不胜愁。\
    谁家今夜扁舟子，何处相思明月楼？\
    可怜楼上月徘徊，应照离人妆镜台。\
    玉户帘中卷不去，捣衣砧上拂还来。\
    此时相望不相闻，愿逐月华流照君。\
    鸿雁长飞光不度，鱼龙潜跃水成文。\
    昨夜闲潭梦落花，可怜春半不还家。\
    江水流春去欲尽，江潭落月复西斜。\
    斜月沉沉藏海雾，碣石潇湘无限路。\
    不知乘月几人归，落月摇情满江树'
s3 = SnowNLP(text3)
print(s3.keywords(limit=5))
s3 = SnowNLP(text3)
print(s3.summary(limit=4))
