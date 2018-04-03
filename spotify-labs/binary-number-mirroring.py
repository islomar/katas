# -*- coding: utf-8 -*-

from expects import *
import pytest

# IMPLEMENTATION
def mirror_binary_number(decimal_number):
    if decimal_number < 1 or decimal_number > 1000000000:
        raise ValueError("The number N must be 1 <= N <= 1_000_000_000")
    binary_number = format(decimal_number, 'b')
    reversed_binary_number = _reverse_string(binary_number)
    return _convert_binary_to_int(reversed_binary_number)

def _convert_decimal_to_binary_number(decimal_number):
    return format(decimal_number, 'b')

def _reverse_string(string_to_be_reversed):
    return string_to_be_reversed[::-1]

def _convert_binary_to_int(binary_number):
    return int(binary_number, 2)


# TESTS
def test_raise_errror_if_number_smaller_than_1():
    with pytest.raises(ValueError, match="The number N must be 1 <= N <= 1_000_000_000"):
        mirror_binary_number(0)

def test_raise_errror_if_number_bigger_than_1_000_000_000():
    with pytest.raises(ValueError, match="The number N must be 1 <= N <= 1_000_000_000"):
        mirror_binary_number(1000000001)

def test_return_11_for_13():
    result = mirror_binary_number(13)

    expect(result).to(equal(11))

def test_return_61_for_47():
    result = mirror_binary_number(47)

    expect(result).to(equal(61))