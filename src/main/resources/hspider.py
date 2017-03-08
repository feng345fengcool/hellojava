#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import unicode_literals
import sys
import os
import re
import time
import random
import datetime
import copy
import codecs
from spider import SpiderHTML
from bs4 import BeautifulSoup

class HouseModel(object):

    def __init__(self, house_name, region_name, owner_name, selled_count, selled_area, selled_avg_price):
        self.house_name = house_name
        self.region_name = region_name
        self.owner_name = owner_name
        self.selled_count = selled_count
        self.selled_area = selled_area
        self.selled_avg_price = selled_avg_price

    def __str__(self):
        return '%s, %s, %s, %s 套, %s 平米, %s 元/平米' % (self.house_name, self.region_name, self.owner_name, self.selled_count, self.selled_area, self.selled_avg_price)


class HouseSpider(SpiderHTML):

    def __init__(self, page_start, page_end):
        self.page_start = page_start
        self.page_end = page_end + 1
        self.url = 'http://www.hzfc.gov.cn/scxx/xmcx_more.php?page=%s&cqid=&key=&select_type=2'
        self.house_list = []
        self.region_house_dic = {}
        self.count_house_dic = {}
        self.price_house_dic = {}

    def get_page(self, num):
        url = self.url % num
        doc = self.get_url(url, 'gbk')
        rets = doc.select('div.policy01 table tr')
        rets_len = len(rets)
        if rets_len < 4:
            return
        rets = rets[1:rets_len-1]
        for item in rets:
            feilds = item.select('td a')
            if len(feilds) >= 6:
                house_name = feilds[0].get_text()
                region_name = feilds[1].get_text()
                owner_name = feilds[2].get_text()
                selled_count = feilds[3].get_text()
                if selled_count == '无成交':
                    selled_count = 0
                else:
                    selled_count = (int)(selled_count.replace('套', ''))
                selled_area = feilds[4].get_text()
                if selled_area == '无成交':
                    selled_area = 0.0
                else:
                    selled_area = (float)(selled_area.replace('m2', ''))
                selled_avg_price = feilds[5].get_text()
                if selled_avg_price == '无成交':
                    selled_avg_price = 0.0
                else:
                    selled_avg_price = (float)(selled_avg_price.replace('元/m2', ''))
                house = HouseModel(house_name, region_name, owner_name, selled_count, selled_area, selled_avg_price)
                self.house_list.append(house)

    def start(self):
        for i in range(self.page_start, self.page_end):
            print '======爬取 第 %s 页======' % i
            self.get_page(i)
        print '爬取 finish !'
        print len(self.house_list)

    def analyse(self):

        region_company_count = {}

        for item in self.house_list:

            if self.region_house_dic.has_key(item.region_name):
                self.region_house_dic[item.region_name].append(item.house_name)
                region_company_count[item.region_name] += 1
            else:
                self.region_house_dic[item.region_name] = []
                self.region_house_dic[item.region_name].append(item.house_name)
                region_company_count[item.region_name] = 1

            if self.count_house_dic.has_key(item.region_name):
                self.count_house_dic[item.region_name] += item.selled_count
            else:
                self.count_house_dic[item.region_name] = 0

            if self.price_house_dic.has_key(item.region_name):
                self.price_house_dic[item.region_name] += item.selled_avg_price
            else:
                self.price_house_dic[item.region_name] = 0.0


        for k in self.region_house_dic:
            print '==========' + k + "==========" + str(self.count_house_dic[k]) + "==========" + str(self.price_house_dic[k]*1.0/region_company_count[k]) + "=========="
            v = self.region_house_dic[k]
            for item in v:
                print item

        house_list = copy.deepcopy(self.house_list)

        house_list.sort(key=lambda x:x.selled_count, reverse=True)
        with codecs.open('/Users/chenshuai/git/house/selled_count.txt', 'w', 'utf-8') as f:  
            for item in house_list:
                f.write(str(item))
                f.write(os.linesep)
        print '==========按照销售套数排序写入文件成功=========='

        house_list.sort(key=lambda x:x.selled_avg_price, reverse=True)
        with codecs.open('/Users/chenshuai/git/house/selled_avg_price.txt', 'w', 'utf-8') as f:
            for item in house_list:
                f.write(str(item))
                f.write(os.linesep)
        print '==========按照房屋均价排序写入文件成功=========='


if __name__ == '__main__':
    print sys.getdefaultencoding()
    reload(sys)
    sys.setdefaultencoding('utf-8')
    house_spider = HouseSpider(1, 49)
    house_spider.start()
    house_spider.analyse()


# 四大对象种类

# Tag <bs4.element.Tag>
# NavigableString <bs4.element.NavigableString>
# BeautifulSoup <bs4.BeautifulSoup>
# Comment <bs4.element.Comment>
