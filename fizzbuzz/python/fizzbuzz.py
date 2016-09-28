# -*- coding: utf-8 -*-

def process(number):
    if number % 3 == 0:
        return 'fizz'
    if number == 5:
        return 'buzz'        
    return str(number)