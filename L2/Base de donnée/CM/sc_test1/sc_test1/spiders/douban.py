import scrapy


class DoubanSpider(scrapy.Spider):
    name = 'douban'
    allowed_domains = ['douban.com']
    start_urls = ['https://www.douban.com/group/topic/262357212/?_i=7478651S5XmnuR']

    def parse(self, response):
        print(response.xpath('//div[@class = "bg-img-green"]//a/text()').extract())
        pass
