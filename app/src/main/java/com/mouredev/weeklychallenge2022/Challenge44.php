<?php

function isBoomerang(int $firstNumber, int $secondNumber, int $thirdNumber): bool {
    return $firstNumber === $thirdNumber && $secondNumber !== $firstNumber;
}

function printBoomerangNumbers(array $numbers): int
{
    if (count($numbers) < 3) {
        return 0;
    }

    $boomerangCount = 0;

    for ($i = 1; $i < count($numbers)-1; $i++) {

        $previousNumber = $numbers[$i - 1];
        $currentNumber = $numbers[$i];
        $nextNumber = $numbers[$i + 1];

        if (isBoomerang($previousNumber, $currentNumber, $nextNumber)) {
            $boomerangCount++;
            echo sprintf("[%s-%s-%s]\n", $previousNumber, $currentNumber, $nextNumber);
        }
    }

    return $boomerangCount;
}

printBoomerangNumbers([2, 1, 2, 3, 3, 4, 2, 4]);