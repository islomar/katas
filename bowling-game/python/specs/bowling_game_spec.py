# -*- coding: utf-8 -*-

from expects import *
from doublex_expects import *
from doublex import *

with describe('Bowling game'):
    with context('when xxx'):
        with it('yyyy'):
            expect('hello').to(equal('hello'))