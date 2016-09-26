# -*- coding: utf-8 -*-

from expects import *

with describe('Fizzbuzz'):
    with context('when running the test'):
        with it('says hello'):
            expect('hello').to(equal('hello'))