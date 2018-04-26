# -*- coding: utf-8 -*-

from expects import *

DECIMAL_TO_ROMAN_NUMBERS = { 1000: "M", 100: "C", 10: "X", 5: "V", 1: "I" }

def convert_to_roman_from_decimal(decimal_number):
    roman_numeral = ""
    last_symbol = ""
    another_decimal_number = decimal_number
    for decimal, roman in sorted(DECIMAL_TO_ROMAN_NUMBERS.items(), reverse=True):
        number_of_similar_symbols = 0
        current_result = ""
        if decimal_number == decimal:
            roman_numeral += DECIMAL_TO_ROMAN_NUMBERS.get(decimal)
            break
        while another_decimal_number / decimal >= 1:
            current_symbol = DECIMAL_TO_ROMAN_NUMBERS.get(decimal)
            current_result += current_symbol
            another_decimal_number -= decimal
            number_of_similar_symbols += 1
            if number_of_similar_symbols == 4:
                current_result = current_symbol + last_symbol
                break
        last_symbol = roman
    number_of_similar_symbols = 0
    roman_numeral += current_result
    return roman_numeral


with describe('Roman Numerals'):
    with context('from decimal number to roman numeral'):
        with it('converts 1 to I'):
            decimal_number = convert_to_roman_from_decimal(1)

            expect(decimal_number).to(equal("I"))

        with it('converts 2 to II'):
            decimal_number = convert_to_roman_from_decimal(2)

            expect(decimal_number).to(equal("II"))

        with it('converts 3 to III'):
            decimal_number = convert_to_roman_from_decimal(3)

            expect(decimal_number).to(equal("III"))

        with it('converts 4 to IV'):
            decimal_number = convert_to_roman_from_decimal(4)

            expect(decimal_number).to(equal("IV"))

        with it('converts 5 to V'):
            decimal_number = convert_to_roman_from_decimal(5)

            expect(decimal_number).to(equal("V"))

        with it('converts 100 to C'):
            decimal_number = convert_to_roman_from_decimal(100)

            expect(decimal_number).to(equal("C"))

        with it('converts 1000 to M'):
            decimal_number = convert_to_roman_from_decimal(1000)

            expect(decimal_number).to(equal("M"))

    with context('from roman numeral to decimal number'):
        with _it('TODO'):
            pass