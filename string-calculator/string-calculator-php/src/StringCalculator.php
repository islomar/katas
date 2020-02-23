<?php

declare(strict_types=1);

namespace Kata;


class StringCalculator
{
    const DELIMITERS_REGEX = "/[,\n]/";

    public function add(string $stringAddends): int
    {
        $delimiters = $this->extractDelimiters($stringAddends);
        $addendsArray = preg_split($delimiters, $stringAddends);
        $intAddends = array_map(array($this, 'convertStringToInt'), $addendsArray);
        return array_sum($intAddends);
    }

    private function extractDelimiters(string $stringAddends):string
    {
        if ($this->startsWith($stringAddends, '//')) {
            $delimiters = array();
            preg_match('/\/\/(.*)\n/', $stringAddends, $delimiters);
            return sprintf('/[%s]/', $delimiters[1]);
        }
        return self::DELIMITERS_REGEX;
    }

    private function startsWith($haystack, $needle): bool
    {
        return strpos($haystack, $needle) === 0;
    }

    private function convertStringToInt(string $stringElement): int
    {
        return (int)$stringElement;
    }
}
