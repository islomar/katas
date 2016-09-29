# -*- coding: utf-8 -*-

from nose.tools import assert_equal
from nose_parameterized import parameterized

import unittest

from fizzbuzz import Fizzbuzz

@parameterized([
    (1, "1"),
    (2, "2"),
    (3, "fizz"),
    (4, "4"),
    (5, "buzz"),
    (13, "fizz"),
    (15, "fizzbuzz"),
    (30, "fizzbuzz"),
    (46, "46"),
])
def test_fizzbuzz(number, expected_result):
    assert_equal(Fizzbuzz().process(number), expected_result)