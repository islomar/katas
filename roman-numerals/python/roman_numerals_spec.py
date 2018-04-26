# -*- coding: utf-8 -*-

from expects import *

def convert_to_decimal_from_roman(decimal_number):
    return "I"


with describe('Roman Numerals'):
    with context('converts from decimal number to roman numeral'):
        with it('converts I to 1'):
            decimal_number = convert_to_decimal_from_roman(1)

            expect(decimal_number).to(equal("I"))

    with context('converts fromn roman numeral to decimal number'):
        with _it('TODO'):
            pass