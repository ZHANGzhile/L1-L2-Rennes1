import requests
from lxml import etree

parser = etree.HTMLParser(encoding="utf-8")
tree = etree.parse('C:/Users/zzl28/Desktop/essai.html',parser=parser)
r1 = tree.xpath('/html/body/h1/text()')
r2 = tree.xpath('//li/text()')
print(r2)



