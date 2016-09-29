# -*- coding: utf-8 -*-

from expects import *
from fizzbuzz import Fizzbuzz

with describe('Fizzbuzz'):

    with before.each:
        self.fizzbuzz = Fizzbuzz()

    with context('when processing 1'):
        with it('returns 1'):
            expect(self.process(1)).to(equal('1'))

    with context('when processing 2'):
        with it('returns 2'):
            expect(self.process(2)).to(equal('2'))            

    with context('when number is divisible by 3'):
        with context('when processing 3'):
            with it('returns fizz'):
                expect(self.process(3)).to(equal('fizz'))

        with context('when processing 9'):
            with it('returns fizz'):
                expect(self.process(9)).to(equal('fizz'))

    with context('when number is divisible by or contains 3'):
        with context('when processing 13'):
            with it('returns fizz'):
                expect(self.process(13)).to(equal('fizz'))                

    with context('when number is divisible by 5'):
        with context('when processing 5'):
            with it('returns buzz'):
                expect(self.process(5)).to(equal('buzz'))            

        with context('when processing 10'):
            with it('returns buzz'):
                expect(self.process(10)).to(equal('buzz'))        

    with context('when number is divisible by 15'):
        with context('when processing 15'):
            with it('returns fizzbuzz'):
                expect(self.process(15)).to(equal('fizzbuzz'))                               

        with context('when processing 30'):
            with it('returns fizzbuzz'):
                expect(self.process(30)).to(equal('fizzbuzz'))    

    def process(self, number):
        return self.fizzbuzz.process(number)       