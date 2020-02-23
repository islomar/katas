<?php
declare(strict_types=1);

namespace Kata\Tests;

use Kata\StringCalculator;
use PHPUnit\Framework\TestCase;

class StringCalculatorTest extends TestCase
{
    public function test_an_empty_list_should_return_0()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("");

        self::assertThat($result, $this->equalTo(0));
    }

    public function test_a_list_separated_with_comma_with_one_element_returns_that_same_element()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("4");

        self::assertThat($result, $this->equalTo(4));
    }

    public function test_adds_a_list_separated_with_comma_with_two_elements()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("1, 2");

        self::assertThat($result, $this->equalTo(3));
    }

    public function test_adds_a_list_separated_with_comma_with_many_elements()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("1,2,3,4,5,6,7,8,9");

        self::assertThat($result, $this->equalTo(45));
    }

    public function test_adds_a_list_with_newline_separator_and_comma()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("1\n2,3");

        self::assertThat($result, $this->equalTo(6));
    }

    public function test_adds_a_list_with_custom_separators()
    {
        $stringCalculator = new StringCalculator();

        $result = $stringCalculator->add("//;\n1;2");

        self::assertThat($result, $this->equalTo(3));
    }

    public function test_negatives_are_not_allowed()
    {
        $this->expectExceptionMessage('negatives not allowed: -2 -3');

        $stringCalculator = new StringCalculator();

        $stringCalculator->add("1,-2,-3");
    }

    // TODO
    // extract setUp()
    // create specific exception
}
