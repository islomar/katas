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
    FIZZ = 'fizz'

    def __init__(self):
        self.rules = self._initialize_rules()

    def process(self, number):
        return [rule.convert(number) for rule in self.rules if rule.applies(number)][0]

    def _initialize_rules(self):
        return sorted([ self._rule_that_returns_fizz_if_number_is_divisible_by_3(),
                        self._rule_that_returns_fizz_if_number_is_divisible_by_or_contains_3(),
                        self._rule_that_returns_fizz_if_number_is_divisible_by_5(),
                        self._rule_that_returns_fizzbuzz_if_number_is_divisible_by_15(),
                        self._default_rule_that_returns_the_same_number_as_string()
    ])

    def _is_divisible_by_or_contains_3(self, number):
        return self._is_divisible_by_3(number) or self._number_contains_digit(number, 3)

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

    def _number_contains_digit(self, number, digit):
        return str(digit) in str(number)

    def _rule_that_returns_fizz_if_number_is_divisible_by_3(self):
        return self._create_fizzbuzz_rule(self._is_divisible_by_3, self.PRIORITY_LOW, lambda number: self.FIZZ)

    def _rule_that_returns_fizz_if_number_is_divisible_by_or_contains_3(self):
        return self._create_fizzbuzz_rule(self._is_divisible_by_or_contains_3, self.PRIORITY_LOW, lambda number: self.FIZZ)

    def _rule_that_returns_fizz_if_number_is_divisible_by_5(self):
        return self._create_fizzbuzz_rule(self._is_divisible_by_5, self.PRIORITY_LOW, lambda number: 'buzz')

    def _rule_that_returns_fizzbuzz_if_number_is_divisible_by_15(self):
        return self._create_fizzbuzz_rule(self._is_divisible_by_15, self.PRIORITY_HIGH, lambda number: 'fizzbuzz')

    def _default_rule_that_returns_the_same_number_as_string(self):
        return self._create_fizzbuzz_rule(self._is_default_rule, self.PRIORITY_FOR_DEFAULT_RULE, lambda number: str(number))

    def _create_fizzbuzz_rule(self, predicate, priority, converter):
        return FizzbuzzRule(predicate, priority, converter)        