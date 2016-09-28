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

    with context('when processing 3'):
        with it('returns fizz'):
            expect(fizzbuzz.process(3)).to(equal('fizz'))

    with context('when processing 9'):
        with it('returns fizz'):
            expect(fizzbuzz.process(9)).to(equal('fizz'))

    with context('when processing 5'):
        with it('returns buzz'):
            expect(fizzbuzz.process(5)).to(equal('buzz'))            