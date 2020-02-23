<?php

declare(strict_types=1);

namespace Kata;


class StringCalculator
{
    const DELIMITER = ',';

    public function add(string $numbers): int
    {
        $numbers = explode(self::DELIMITER, $numbers);
        $array_map = array_map(array($this, 'convertStringToInt'), $numbers);
        return array_sum($array_map);
    }

    private function convertStringToInt(string $stringElement): int
    {
        return (int)$stringElement;
    }
}
