<?php

declare(strict_types = 1);

namespace Kata;



class StringCalculator
{
    public function add(string $numbers):int {
        $numbers = explode(',', $numbers);
        $convertToInt = function (string $stringElement):int {
            return (int)$stringElement;
        };
        $array_map = array_map($convertToInt, $numbers);
        return array_sum($array_map);
    }


}
