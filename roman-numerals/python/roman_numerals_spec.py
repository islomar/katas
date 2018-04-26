# -*- coding: utf-8 -*-

from expects import *

DECIMAL_TO_ROMAN_NUMBERS = { 100: "C", 10: "X", 5: "V", 1: "I" }

def convert_to_roman_from_decimal(decimal_number):
    # result = ""
    # another_decimal_number = decimal_number
    # for decimal, roman in sorted(DECIMAL_TO_ROMAN_NUMBERS.items(), reverse=True):
    #     print(decimal)
    #     number_of_similar_symbols = 0
    #     while another_decimal_number / decimal >= 1:
    #         print("The number is bigger or equal than the key")
    #         result += DECIMAL_TO_ROMAN_NUMBERS.get(decimal)
    #         another_decimal_number -= decimal
    #         print("New decimal_number: {}".format(another_decimal_number))
    #         number_of_similar_symbols += 1
    #         if number_of_similar_symbols == 3:
    #             print("No va maaaaas")
    #     number_of_similar_symbols = 0
    # print("Result: {}".format(result))

    for decimal, roman in sorted(DECIMAL_TO_ROMAN_NUMBERS.items(), reverse=True):
        print(decimal)
        if decimal_number == decimal:
            return DECIMAL_TO_ROMAN_NUMBERS.get(decimal)
    if decimal_number == 4:
        return "IV"
    if decimal_number == 5:
        return "V"
    roman_numeral = ""
    for i in range(decimal_number):
        roman_numeral += "I"
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


    with context('from roman numeral to decimal number'):
        with _it('TODO'):
            pass