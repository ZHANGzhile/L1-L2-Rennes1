import scrapy


class IndexSpider(scrapy.Spider):
    name = 'index'
    allowed_domains = ['baidu.com']
    start_urls = ['https://www.baidu.com/s?wd=xpath&rsv_spt=1&rsv_iqid=0xdd9fa8c6003df654&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_dl=tb&rsv_sug3=5&rsv_enter=1&rsv_sug1=1&rsv_sug7=100&rsv_sug2=0&rsv_btype=i&prefixsug=xpath&rsp=5&inputT=1601&rsv_sug4=1601']

    def parse(self, response):
        print(response.xpath('//*[@id="1"]/div//div[@class="title_1v7d9"]/a/text()').extract())
        pass
