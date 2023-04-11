from abc import ABC

import scrapy

#http://www.jihaoba.com/escrow/
class PhoneSipader(scrapy.Spider, ABC):
    name = 'phone'
    start_urls = [
        'http://www.jihaoba.com/escrow/'
    ]

    def parse(self, response):
            phone = response.xpath('//div[@class="numbershow"]/ul').xpath('li[contains(@class,"number")]/a/text()').extract_first()

            print(phone)