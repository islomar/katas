<?php

declare(strict_types=1);

namespace Kata;


class StringCalculator
{
    const DELIMITERS = "/[,\n]/";

    public function add(string $stringAddends): int
    {
        $addendsArray = preg_split(self::DELIMITERS, $stringAddends);
        $intAddends = array_map(array($this, 'convertStringToInt'), $addendsArray);
        return array_sum($intAddends);
    }

    private function convertStringToInt(string $stringElement): int
    {
        return (int)$stringElement;
    }
}
