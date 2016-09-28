# -*- coding: utf-8 -*-

def process(number):
    if _is_divisible_by(number, 15):
        return 'fizzbuzz'    
    if _is_divisible_by(number, 3):
        return 'fizz'
    if _is_divisible_by(number, 5):
        return 'buzz'            
    return str(number)

def _is_divisible_by(number, divisor):
    return number % divisor == 0
