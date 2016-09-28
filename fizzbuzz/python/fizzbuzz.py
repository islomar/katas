# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, dividend, priority, converter):
        self.dividend = dividend
        self.priority = priority
        self.converter = converter

    def applies(self, number):
        return number % self.dividend == 0

    def convert(self, number):
        return self.converter(number)

    def __cmp__(self, other):
        if hasattr(other, 'priority'):
            return self.priority.__cmp__(other.priority)


PRIORITY_HIGH = 1
PRIORITY_LOW = 2
RULES =[DivisibleByRule(3, PRIORITY_LOW, lambda number: 'fizz'),
        DivisibleByRule(5, PRIORITY_LOW, lambda number: 'buzz'),
        DivisibleByRule(15, PRIORITY_HIGH, lambda number: 'fizzbuzz')
]

def process(number):
    for rule in sorted(RULES):
        if rule.applies(number):
            return rule.convert(number)
    return str(number)