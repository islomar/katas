# -*- coding: utf-8 -*-

from expects import *
import pytest


class CatsAndDogsTestCase(object):
    def __init__(self, number_of_cats, number_of_dogs, voters):
        self.number_of_cats = number_of_cats
        self.number_of_dogs = number_of_dogs
        self.voters = voters

    def __repr__(self):
        return "%s %s" % (self.__class_name_without_module(), self.__dict__)

    def __class_name_without_module(self):
        return self.__class__.__name__.split('.')[-1]



class Voter(object):
    def __init__(self, pet_to_keep, pet_to_drop):
        self.pet_to_keep = pet_to_keep
        self.pet_to_drop = pet_to_drop

    def __repr__(self):
        return "%s %s" % (self.__class_name_without_module(), self.__dict__)

    def __class_name_without_module(self):
        return self.__class__.__name__.split('.')[-1]


class InputToTestCasesMapper(object):
    def convert_input_to_test_cases(self, input):
        lines = input.splitlines()
        number_of_testcases = int(lines[0])
        test_cases = lines[1:]
        index_for_next_testcase_header = 0
        test_cases_model = []

        for test_case in range(number_of_testcases):
            test_case = self._extract_test_case(test_cases, index_for_next_testcase_header)
            test_cases_model.append(test_case)
            index_for_next_testcase_header += len(test_case.voters) + 1
        return test_cases_model

    def _extract_test_case(self, test_cases, index_for_next_testcase_header):
            first_test_case_header = test_cases[index_for_next_testcase_header]
            number_of_cats, number_of_dogs, number_of_voters = _parse_header(first_test_case_header)
            print('{} number_of_cats, {} number_of_dogs, {} voters'.format(number_of_cats, number_of_dogs, number_of_voters))

            test_case_votes = test_cases[index_for_next_testcase_header + 1:index_for_next_testcase_header + 1 + number_of_voters]
            print(test_case_votes)

            voters = self._extract_voters(number_of_voters, test_case_votes)
            
            return CatsAndDogsTestCase(number_of_cats, number_of_dogs, voters)

    def _extract_voters(self, number_of_voters, test_case_votes):
        voters = []
        for voter_index in range(number_of_voters):
            pet_to_keep, pet_to_drop = test_case_votes[voter_index].split()
            voter = Voter(pet_to_keep, pet_to_drop)
            print(voter)
            voters.append(voter)
        return voters

# 2
# 1 1 2
# C1 D1
# D1 C1
# 1 2 4
# C1 D1
# C1 D1
# C1 D2
# D2 C1
def test_xx():
    input = """2
1 1 2
C1 D1
D1 C1
1 2 4
C1 D1
C1 D1
C1 D2
D2 C1"""
    result = InputToTestCasesMapper().convert_input_to_test_cases(input)

    print(result)


def _parse_header(header):
    number_of_cats, number_of_dogs, number_of_voters = header.split()
    return int(number_of_cats), int(number_of_dogs), int(number_of_voters)