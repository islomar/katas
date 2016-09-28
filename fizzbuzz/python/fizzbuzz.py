# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, dividend, result, priority):
        self.dividend = dividend
        self.result = result
        self.priority = priority

    def applies(self, number):
        return number % self.dividend == 0

    def __cmp__(self, other):
        if hasattr(other, 'priority'):
            return self.priority.__cmp__(other.priority)


PRIORITY_HIGH = 1
PRIORITY_LOW = 2
RULES =[DivisibleByRule(3, 'fizz', PRIORITY_LOW),
        DivisibleByRule(5, 'buzz', PRIORITY_LOW),
        DivisibleByRule(15, 'fizzbuzz', PRIORITY_HIGH)
]

def process(number):
    for rule in sorted(RULES):
        if rule.applies(number):
            return rule.result
    return str(number)