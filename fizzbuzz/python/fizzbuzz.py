# -*- coding: utf-8 -*-
from collections import OrderedDict

class FizzbuzzRule(object):

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
    PRIORITY_FOR_DEFAULT_RULE = 3

    def __init__(self):
        self.rules = sorted([   FizzbuzzRule(self._is_divisible_by_3, self.PRIORITY_LOW, lambda number: 'fizz'),
                                FizzbuzzRule(self._is_divisible_by_or_contains_3, self.PRIORITY_LOW, lambda number: 'fizz'),
                                FizzbuzzRule(self._is_divisible_by_5, self.PRIORITY_LOW, lambda number: 'buzz'),
                                FizzbuzzRule(self._is_divisible_by_15, self.PRIORITY_HIGH, lambda number: 'fizzbuzz'),
                                FizzbuzzRule(self._is_default_rule, self.PRIORITY_FOR_DEFAULT_RULE, lambda number: str(number)),
    ])

    def process(self, number):
        return [rule.convert(number) for rule in self.rules if rule.applies(number)][0]

    def _is_divisible_by_or_contains_3(self, number):
        return self._is_divisible_by_3(number) or str(3) in str(number)

    def _is_divisible_by_3(self, number):
        return self._is_divisible_by(number, 3)

    def _is_divisible_by_5(self, number):
        return self._is_divisible_by(number, 5)

    def _is_divisible_by_15(self, number):
        return self._is_divisible_by(number, 15)   

    def _is_divisible_by(self, number, dividend):
        return number % dividend == 0

    def _is_default_rule(self, number):
        return True