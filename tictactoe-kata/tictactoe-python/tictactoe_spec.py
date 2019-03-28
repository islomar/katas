# -*- coding: utf-8 -*-

from expects import *

with describe('Tic tac toe'):

    with before.each:
        pass

    with context('when xxx'):
        with it('yyy'):
            expect(1).to(equal(1))
   