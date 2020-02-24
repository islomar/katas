<?php
declare(strict_types=1);

namespace Kata\Tests;

use Kata\Exceptions\InvalidNumberException;
use Kata\StringCalculator;
use PHPUnit\Framework\TestCase;

class StringCalculatorTest extends TestCase
{
    protected $stringCalculator;

    protected function setUp()
    {
        $this->stringCalculator = new StringCalculator();
    }

    public function test_an_empty_list_should_return_0()
    {
        $result = $this->stringCalculator->add('');

        self::assertThat($result, $this->equalTo(0));
    }

    public function test_a_list_separated_with_comma_with_one_element_returns_that_same_element()
    {
        $result = $this->stringCalculator->add('4');

        self::assertThat($result, $this->equalTo(4));
    }

    public function test_adds_a_list_separated_with_comma_with_two_elements()
    {
        $result = $this->stringCalculator->add('1, 2');

        self::assertThat($result, $this->equalTo(3));
    }

    public function test_adds_a_list_separated_with_comma_with_many_elements()
    {
        $result = $this->stringCalculator->add('1,2,3,4,5,6,7,8,9');

        self::assertThat($result, $this->equalTo(45));
    }

    public function test_adds_a_list_with_newline_separator_and_comma()
    {
        $result = $this->stringCalculator->add("1\n2,3");

        self::assertThat($result, $this->equalTo(6));
    }

    public function test_adds_a_list_with_custom_separators()
    {
        $result = $this->stringCalculator->add("//;\n1;2");

        self::assertThat($result, $this->equalTo(3));
    }

    public function test_negatives_are_not_allowed()
    {
        $this->expectException(InvalidNumberException::class);
        $this->expectExceptionMessage('negatives not allowed: -2 -3');

        $this->stringCalculator->add('1,-2,-3');
    }

//Add("1001, 2") // 2
    public function test_ignore_numbers_bigger_than_1000()
    {
        $result = $this->stringCalculator->add("1001, 2");

        self::assertThat($result, $this->equalTo(2));
    }

    public function test_allow_number_1000()
    {
        $result = $this->stringCalculator->add("1000, 2");

        self::assertThat($result, $this->equalTo(1002));
    }
}
