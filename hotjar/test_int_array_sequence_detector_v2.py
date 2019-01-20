# -*- coding: utf-8 -*-
import itertools
import unittest
# Given an array of ints, return True if the sequence.. 1, 3, 4 .. appears in the array somewhere

SEARCHED_SEQUENCE = [1, 3, 4]

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


def contains_sequence(numbers, searched_sequence):
    searched_sequence_length = len(searched_sequence)
    input_length = len(numbers)
    if input_length < searched_sequence_length:
        return False
    for index in range(input_length - searched_sequence_length + 1):
        if (numbers[index] == searched_sequence[0] and numbers[index + 1] == searched_sequence[1] and numbers[index + 2] == searched_sequence[2]):
        #if _has_sequence_contained_from_index(numbers, searched_sequence, searched_sequence_length, index):
            return True
    return False

def _has_sequence_contained_from_index(numbers, searched_sequence, searched_sequence_length, index):
    offset = searched_sequence_length
    for i in range(searched_sequence_length):
        print(numbers[i])
    #return numbers[index] == searched_sequence[searched_sequence_length]    

def contains_sequence_recursive(numbers, searched_sequence):
    searched_sequence_length = len(searched_sequence)
    input_length = len(numbers)
    if input_length < searched_sequence_length:
        print('ERROR: Then minimum length of the array of ints should be {}!'.format(searched_sequence_length))
        return
    return _x(numbers, searched_sequence, 0)

def _x(numbers, searched_sequence, index):
    if index > len(searched_sequence):
        return False
    if numbers[index] == searched_sequence[index]:
        return _x[numbers[1:], searched_sequence[1:], index + 1]

#if __name__ == '__main__':
    #print(contains_sequence([1, 3, 45, 8, 1, 3, 4, 9], SEARCHED_SEQUENCE))
    #print(contains_sequence([1, 9], SEARCHED_SEQUENCE))
    #print(SEARCHED_SEQUENCE[1:])
    #print(contains_sequence_recursive([1, 3, 4], SEARCHED_SEQUENCE))

if __name__ == '__main__':
    unittest.main()