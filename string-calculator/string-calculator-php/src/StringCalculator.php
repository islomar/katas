<?php

declare(strict_types = 1);

namespace Kata;

use phpDocumentor\Reflection\Types\Integer;

class StringCalculator
{
    public function add(string $numbers):int {
        return (int)$numbers;
    }
}
