# -*- coding: utf-8 -*-

from expects import *
import fizzbuzz

with describe('Fizzbuzz'):
    with context('when processing 1'):
        with it('returns 1'):
            expect(fizzbuzz.process(1)).to(equal('1'))

    with context('when processing 2'):
        with it('returns 2'):
            expect(fizzbuzz.process(2)).to(equal('2'))            