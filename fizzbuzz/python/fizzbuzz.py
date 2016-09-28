# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, dividend, result, priority):
        self.dividend = dividend
        self.result = result
        self.priority = priority

    def applies(self, number):
        return number % self.dividend == 0



PRIORITY_HIGH = 1
PRIORITY_LOW = 2
RULES =[DivisibleByRule(3, 'fizz', PRIORITY_LOW),
        DivisibleByRule(5, 'buzz', PRIORITY_LOW),
        DivisibleByRule(15, 'fizzbuzz', PRIORITY_HIGH)
]

def process(number):
    for rule in sorted(RULES, key=_get_priority):
        if rule.applies(number):
            return rule.result
    return str(number)

def _is_divisible_by(number, divisor):
    return number % divisor == 0

def _get_priority(rule):
    return rule.priority