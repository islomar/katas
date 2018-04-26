# -*- coding: utf-8 -*-

from expects import *

def convert_to_decimal_from_roman(decimal_number):
    roman_numeral = ""
    for i in range(decimal_number):
        roman_numeral += "I"
    return roman_numeral


with describe('Roman Numerals'):
    with context('from decimal number to roman numeral'):
        with it('converts I to 1'):
            decimal_number = convert_to_decimal_from_roman(1)

            expect(decimal_number).to(equal("I"))

        with it('converts II to 2'):
            decimal_number = convert_to_decimal_from_roman(2)

            expect(decimal_number).to(equal("II"))

        with it('converts III to 3'):
            decimal_number = convert_to_decimal_from_roman(3)

            expect(decimal_number).to(equal("III"))



    with context('from roman numeral to decimal number'):
        with _it('TODO'):
            pass