<?php
declare(strict_types=1);

namespace Kata\Tests;

use Kata\StringCalculator;
use PHPUnit\Framework\TestCase;

// "" -> 0
// "4" -> 4
class StringCalculatorTest extends TestCase
{
    public function test_an_empty_list_should_return_0()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("");

        self::assertThat($result, $this->equalTo(0));
    }
}
