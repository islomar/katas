# -*- coding: utf-8 -*-
import itertools
import unittest

SEARCHED_SEQUENCE = [1, 3, 4]


# Exercise: Given an array of ints, return True if the sequence.. 1, 3, 4 .. appears in the array somewhere
def contains_sequence(numbers, searched_sequence):
    searched_sequence_length = len(searched_sequence)
    input_length = len(numbers)
    if input_length < searched_sequence_length:
        return False
    for index in range(input_length - searched_sequence_length + 1):
        if (numbers[index] == searched_sequence[0] and numbers[index + 1] == searched_sequence[1] and numbers[index + 2] == searched_sequence[2]):
            return True
    return False


# To run the tests, from the command line type:  python -test_int_array_sequence_detector.py -v
class TestSequenceDetector(unittest.TestCase):
    def test_a_long_array_containing_the_sequence_should_resturn_True(self):
        self.assertTrue(contains_sequence([1, 3, 45, 8, 1, 3, 4, 9], SEARCHED_SEQUENCE))

    def test_an_array_containing_exactly_the_sequence_should_resturn_True(self):
        self.assertTrue(contains_sequence(SEARCHED_SEQUENCE, SEARCHED_SEQUENCE))

    def test_a_long_array_not_containing_the_sequence_should_resturn_False(self):
        self.assertFalse(contains_sequence([1, 3, 45, 8, 1, 4, 9], SEARCHED_SEQUENCE))

    def test_too_short_sequence_should_return_False(self):
        self.assertFalse(contains_sequence([1, 4], SEARCHED_SEQUENCE))

    def test_an_array_containing_the_sequence_numbers_non_consecutively_should_return_False(self):
        self.assertFalse(contains_sequence([1, 2, 3, 4], SEARCHED_SEQUENCE))

if __name__ == '__main__':
    unittest.main()