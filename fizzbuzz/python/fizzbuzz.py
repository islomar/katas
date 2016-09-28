# -*- coding: utf-8 -*-
from collections import OrderedDict

RULES = OrderedDict([   (15, 'fizzbuzz'), 
                        (3, 'fizz'), 
                        (5, 'buzz')
                    ])

def process(number):
    for dividend, result in RULES.iteritems():
        if _is_divisible_by(number, dividend):
            return result
    return str(number)

def _is_divisible_by(number, divisor):
    return number % divisor == 0
