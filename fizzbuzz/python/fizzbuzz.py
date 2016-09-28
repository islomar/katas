# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, dividend, result, priority):
        self.dividend = dividend
        self.result = result
        self.priority = priority

    def applies(self, number):
        return number % self.dividend == 0




RULES =[DivisibleByRule(3, 'fizz', 2),
        DivisibleByRule(5, 'buzz', 2),
        DivisibleByRule(15, 'fizzbuzz', 1)
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