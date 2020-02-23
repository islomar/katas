<?php
declare(strict_types=1);

namespace Kata\Tests;

use Kata\StringCalculator;
use PHPUnit\Framework\TestCase;

class StringCalculatorTest extends TestCase
{
    public function testStringCalculatorIsDefined()
    {
        $stringCalculator = new StringCalculator();

        $this->assertNotEmpty($stringCalculator);
    }
}
