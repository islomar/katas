# -*- coding: utf-8 -*-

from fizzbuzz import Fizzbuzz


def main():
    fizzbuzz = Fizzbuzz()
    for i in range(1, 101):
        print(i, fizzbuzz.process(i))

if __name__ == '__main__':
    main()