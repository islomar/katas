# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, dividend, result):
        self.dividend = dividend
        self.result = result

    def applies(self, number):
        return number % self.dividend == 0




RULES =[DivisibleByRule(15, 'fizzbuzz'), 
        DivisibleByRule(3, 'fizz'),
        DivisibleByRule(5, 'buzz')
]

def process(number):
    for rule in RULES:
        if rule.applies(number):
            return rule.result
    return str(number)

def _is_divisible_by(number, divisor):
    return number % divisor == 0