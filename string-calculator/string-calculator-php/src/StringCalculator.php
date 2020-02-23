<?php

declare(strict_types=1);

namespace Kata;


class StringCalculator
{
    const DELIMITER = ',';

    public function add(string $stringAddends): int
    {
        $addendsArray = explode(self::DELIMITER, $stringAddends);
        $intAddends = array_map(array($this, 'convertStringToInt'), $addendsArray);
        return array_sum($intAddends);
    }

    private function convertStringToInt(string $stringElement): int
    {
        return (int)$stringElement;
    }
}
