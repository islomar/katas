# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, dividend, result):
        self.dividend = dividend
        self.result = result

    def applies(self, number):
        return number % self.dividend == 0




RULES = OrderedDict([   (DivisibleByRule(15, 'fizzbuzz'), 'fizzbuzz'), 
                        (DivisibleByRule(3, 'fizz'), 'fizz'), 
                        (DivisibleByRule(5, 'buzz'), 'buzz')
                    ])

def process(number):
    for rule, result in RULES.iteritems():
        if rule.applies(number):
            return result
    return str(number)

def _is_divisible_by(number, divisor):
    return number % divisor == 0