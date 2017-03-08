#!/usr/bin/env python
# -*- coding: utf-8 -*-

import os
import re
import codecs
import urllib2
import io
import gzip
import zlib
from bs4 import BeautifulSoup
import chardet

class SpiderHTML(object):

	def get_url(self, url, coding='utf_8'):
		req = urllib2.Request(url)
		req.add_header('User-Agent', 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36')
		req.add_header('Accept-encoding', 'gzip')
		rsp = urllib2.urlopen(req, timeout=120)
		html = rsp.read()
		gzipd = rsp.headers.get('Content-Encoding')
		if gzipd == 'gzip':
			data = zlib.decompress(html, 16+zlib.MAX_WBITS)
		else:
			data = rsp.read()
		return BeautifulSoup(data.decode(coding), "html.parser")
