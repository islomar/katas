<?php

declare(strict_types=1);

namespace Kata;


use Exception;
use Kata\Exceptions\InvalidNumberException;

class StringCalculator
{
    const DEFAULT_SEPARATORS_REGEX = '/[,\n]/';
    const CUSTOM_SEPARATORS_PATTERN = '/\/\/(.*)\n/';
    const REGEX_FORMAT = '/[%s]/';

    public function add(string $stringAddends): int
    {
        $delimiters = $this->extractDelimiters($stringAddends);
        $addendsArray = preg_split($delimiters, $stringAddends);
        $intAddends = array_map(array($this, 'convertStringToInt'), $addendsArray);
        $this->validateAddends($intAddends);
        return array_sum($intAddends);
    }

    private function extractDelimiters(string $stringAddends):string
    {
        if ($this->hasCustomSeparators($stringAddends)) {
            $delimiters = array();
            preg_match(self::CUSTOM_SEPARATORS_PATTERN, $stringAddends, $delimiters);
            return sprintf(self::REGEX_FORMAT, $delimiters[1]);
        }
        return self::DEFAULT_SEPARATORS_REGEX;
    }

    private function startsWith($haystack, $needle): bool
    {
        return strpos($haystack, $needle) === 0;
    }

    private function convertStringToInt(string $stringElement): int
    {
        return (int)$stringElement;
    }

    private function hasCustomSeparators(string $stringAddends): bool
    {
        return $this->startsWith($stringAddends, '//');
    }

    private function validateAddends(array $intAddends)
    {
        $negative_numbers = array_filter($intAddends, array($this, 'isNegative'));
        if (!empty($negative_numbers)) {
          throw new InvalidNumberException(sprintf('negatives not allowed: %s', implode(' ', $negative_numbers)));
        }
    }

    private function isNegative(int $number):bool {
        return $number < 0;
    }
}
