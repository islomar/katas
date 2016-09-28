# -*- coding: utf-8 -*-
from collections import OrderedDict

class DivisibleByRule(object):

    def __init__(self, condition, priority, converter):
        self.condition = condition
        self.priority = priority
        self.converter = converter

    def applies(self, number):
        return self.condition(number)

    def convert(self, number):
        return self.converter(number)

    def __cmp__(self, other):
        if hasattr(other, 'priority'):
            return self.priority.__cmp__(other.priority)


def _is_divisible_by_3(number):
    return _is_divisible_by(number, 3)

def _is_divisible_by_5(number):
    return _is_divisible_by(number, 5)

def _is_divisible_by_15(number):
    return _is_divisible_by(number, 15)   

def _is_divisible_by(number, dividend):
    return number % dividend == 0

PRIORITY_HIGH = 1
PRIORITY_LOW = 2
RULES =[DivisibleByRule(_is_divisible_by_3, PRIORITY_LOW, lambda number: 'fizz'),
        DivisibleByRule(_is_divisible_by_5, PRIORITY_LOW, lambda number: 'buzz'),
        DivisibleByRule(_is_divisible_by_15, PRIORITY_HIGH, lambda number: 'fizzbuzz')
]

def process(number):
    for rule in sorted(RULES):
        if rule.applies(number):
            return rule.convert(number)
    return str(number)