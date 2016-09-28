# -*- coding: utf-8 -*-

from expects import *
import fizzbuzz

with describe('Fizzbuzz'):
    with context('when processing 1'):
        with it('returns 1'):
            expect(fizzbuzz.process(1)).to(equal('1'))