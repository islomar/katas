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


class Fizzbuzz(object):
    PRIORITY_HIGH = 1
    PRIORITY_LOW = 2

    def __init__(self):
        self.rules = [  DivisibleByRule(self._is_divisible_by_3, self.PRIORITY_LOW, lambda number: 'fizz'),
                        DivisibleByRule(self._is_divisible_by_5, self.PRIORITY_LOW, lambda number: 'buzz'),
                        DivisibleByRule(self._is_divisible_by_15, self.PRIORITY_HIGH, lambda number: 'fizzbuzz')
    ]

    def process(self, number):
        for rule in sorted(self.rules):
            if rule.applies(number):
                return rule.convert(number)
        return str(number)

    def _is_divisible_by_3(self, number):
        return self._is_divisible_by(number, 3)

    def _is_divisible_by_5(self, number):
        return self._is_divisible_by(number, 5)

    def _is_divisible_by_15(self, number):
        return self._is_divisible_by(number, 15)   

    def _is_divisible_by(self, number, dividend):
        return number % dividend == 0