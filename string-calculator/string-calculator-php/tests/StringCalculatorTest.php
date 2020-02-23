<?php
declare(strict_types=1);

namespace Kata\Tests;

use Kata\StringCalculator;
use PHPUnit\Framework\TestCase;

// "" -> 0
// "4" -> 4
// "1,2" -> 3
class StringCalculatorTest extends TestCase
{
    public function test_an_empty_list_should_return_0()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("");

        self::assertThat($result, $this->equalTo(0));
    }

    public function test_a_list_with_one_element_returns_that_same_element()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("4");

        self::assertThat($result, $this->equalTo(4));
    }
}
