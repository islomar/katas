# -*- coding: utf-8 -*-

import json
from operator import itemgetter
from os import linesep

from expects import *
import pytest


# IMPLEMENTATION WITH OBJECTS
class Song(object):
    def __init__(self, number_of_songs, name, number_of_times_listened, song_index):
        self.name = name
        self.quality = number_of_times_listened / (number_of_songs - song_index)

    def __repr__(self):
        return "%s %s" % (self.__class_name_without_module(), self.__dict__)

    def __class_name_without_module(self):
        return self.__class__.__name__.split('.')[-1]

def extract_most_listened_songs_names_oo(input):
    lines = input.splitlines()
    number_of_songs, number_of_songs_to_select = _parse_first_line(lines)
    sorted_songs = _sort_all_songs_by_quality_oo(lines, number_of_songs)
    sorted_name_list = list(map(lambda song: song.name, sorted_songs[:number_of_songs_to_select]))
    return linesep.join(sorted_name_list)

def _sort_all_songs_by_quality_oo(lines, number_of_songs):
    songs = []
    for index, song in enumerate(lines[1:]):
        name_of_the_song = song.split()[1]
        number_of_times_listened = int(song.split()[0])
        songs.append(Song(number_of_songs, name_of_the_song, number_of_times_listened, index))
    return sorted(songs, key=lambda song: song.quality, reverse=True)



# IMPLEMENTATION WITH PRIMITIVES
def extract_most_listened_songs_names(input):
    lines = input.splitlines()
    number_of_songs, number_of_songs_to_select = _parse_first_line(lines)
    sorted_songs = _sort_all_songs_by_quality(lines, number_of_songs)
    return _extract_song_names(number_of_songs_to_select, sorted_songs)

def _sort_all_songs_by_quality(lines, number_of_songs):
    song_name_to_quality = dict()
    songs = []
    for index, song in enumerate(lines[1:]):
        normalized_number_of_times_listened = _normalize_number_of_times_listened(song, number_of_songs, index)
        name_of_the_song = song.split()[1]
        song_name_to_quality[name_of_the_song] = normalized_number_of_times_listened
        songs.append(Song(number_of_songs, name_of_the_song, int(song.split()[0]), index))
    return sorted(song_name_to_quality.items(), key=itemgetter(1), reverse=True)

def _extract_song_names(number_of_songs_to_select, sorted_songs):
    result = []
    for index in range(number_of_songs_to_select):
        result.append(sorted_songs[index][0])
    return linesep.join(result)

def _parse_first_line(lines):
    first_line = lines[0].split()
    number_of_songs = int(first_line[0])
    number_of_songs_to_select = int(first_line[1])
    return number_of_songs, number_of_songs_to_select

def _normalize_number_of_times_listened(song, number_of_songs, index):
    number_of_times_listened = int(song.split()[0])
    return number_of_times_listened / (number_of_songs - index)


# TESTS
def test_with_four_songs():
    input = """4 2
30 one
30 two
15 three
25 four
"""
    expected_output = """four
two"""
    most_listened_songs_names = extract_most_listened_songs_names_oo(input)

    expect(most_listened_songs_names).to(equal(expected_output))


def test_with_fifteen_songs():
    input = """15 3
197812 re_hash
78906 5_4
189518 tomorrow_comes_today
39453 new_genious
210492 clint_eastwood
26302 man_research
22544 punk
19727 sound_check
17535 double_bass
18782 rock_the_house
198189 19_2000
13151 latin_simone
12139 starshine
11272 slow_country
10521 m1_a1
"""
    expected_output = """19_2000
clint_eastwood
tomorrow_comes_today"""
    most_listened_songs_names = extract_most_listened_songs_names(input)

    expect(most_listened_songs_names).to(equal(expected_output))


