<?php
/*
 * Enunciado: Dado un array de números enteros positivos, donde cada uno
 * representa unidades de bloques apilados, debemos calcular cuantas unidades
 * de agua quedarán atrapadas entre ellos.
 *
 * - Ejemplo: Dado el array [4, 0, 3, 6, 1, 3].
 *
 *         ⏹
 *         ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹💧⏹
 *   ⏹💧⏹⏹💧⏹⏹⏹⏹
 *   ⏹💧⏹⏹⏹⏹⏹⏹⏹⏹
 *
 *   Representando bloque con ⏹︎ y agua con 💧, quedarán atrapadas 7 unidades
 *   de agua. Suponemos que existe un suelo impermeable en la parte inferior
 *   que retiene el agua.
 */

/** SOLUTION TEST */

/*
 *
 */
assertEquals(0, getNumberOfWater([]));


/*
 *
 *
 *   ⏹
 *   ⏹
 *   ⏹
 *   ⏹
 */
assertEquals(0, getNumberOfWater([4]));



/*
 *     ⏹
 *     ⏹
 *   ⏹⏹
 *   ⏹⏹
 *   ⏹⏹
 *   ⏹⏹
 */
assertEquals(0, getNumberOfWater([4, 6]));

/*
 *
 *       ⏹
 *     ⏹⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 */
assertEquals(0, getNumberOfWater([3, 4, 5]));


/*
 *
 *   ⏹
 *   ⏹⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 */
assertEquals(0, getNumberOfWater([5, 4, 3]));

/*
 *
 *   ⏹💧⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 *   ⏹⏹⏹
 */
assertEquals(1, getNumberOfWater([5, 4, 5]));

/*
 *
 *         ⏹
 *         ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹💧⏹
 *   ⏹💧⏹⏹⏹⏹
 */
assertEquals(7, getNumberOfWater([4, 0, 3, 6, 1, 3]));

/*
 *
 *         ⏹
 *         ⏹
 *   ⏹💧💧⏹
 *   ⏹💧⏹⏹💧⏹💧⏹
 *   ⏹💧⏹⏹💧⏹⏹⏹⏹
 *   ⏹💧⏹⏹⏹⏹⏹⏹⏹⏹
 */
assertEquals(8, getNumberOfWater([4, 0, 3, 6, 1, 3, 2, 3, 3, 1]));

/*
 *             ⏹
 *         ⏹💧⏹
 *         ⏹💧⏹
 *   ⏹💧💧⏹💧⏹
 *   ⏹💧⏹⏹💧⏹💧⏹
 *   ⏹💧⏹⏹💧⏹⏹⏹⏹
 *   ⏹💧⏹⏹⏹⏹⏹⏹⏹⏹
 */
assertEquals(11, getNumberOfWater([4, 0, 3, 6, 1, 7, 2, 3, 3, 1]));


function assertEquals($expectedValue, $actualValue): void
{
    if ($expectedValue !== $actualValue) {
        echo "$actualValue should be $expectedValue\n";
    } else {
        echo "OK\n";
    }
}

function getNumberOfWater(array $blocksCountByRow): int
{

    if (count($blocksCountByRow) < 3) {
        return 0;
    }

    $watter = 0;
    $highestNumberOfBlocksInPreviousRows = null;
    $highestNumberOfBlocksInNextRows = null;

    for ($row = 1; $row < count($blocksCountByRow) - 1; $row++) {
        $currentRowBlocks = $blocksCountByRow[$row];

        if ($highestNumberOfBlocksInPreviousRows !== $currentRowBlocks) {
            //Find the highest number of blocks in previous rows
            $highestNumberOfBlocksInPreviousRows = findTheHighestBlockNumberBeingIncremental(
                array_reverse(
                    array_slice(
                        $blocksCountByRow,
                        0,
                        $row)
                )
            );
        }

        if ($highestNumberOfBlocksInNextRows !== $currentRowBlocks) {
            //Find the highest number of blocks in next rows
            $highestNumberOfBlocksInNextRows = findTheHighestBlockNumberBeingIncremental(
                array_slice(
                    $blocksCountByRow,
                    $row
                )
            );
        }

        if ($highestNumberOfBlocksInPreviousRows === null || $highestNumberOfBlocksInNextRows === null) {
            throw new LogicException(
                sprintf(
                "This can't happen because we iterate the blocks from the second one to the penultimate. \n
                Values: %s, %s\n
                Current number: %s\n
                Current row: %s
                ",
                    $highestNumberOfBlocksInPreviousRows,
                    $highestNumberOfBlocksInNextRows,
                    $currentRowBlocks,
                    $row
                )
            );
        }

        $lowerCountOfBLocks = min($highestNumberOfBlocksInPreviousRows, $highestNumberOfBlocksInNextRows);

        if ($lowerCountOfBLocks >= $currentRowBlocks) {
            $watter += $lowerCountOfBLocks - $currentRowBlocks;
        }
    }

    return $watter;
}

/**
 * This function is prepared to work with any size of array.
 * We will return null if array has zero elements
 * @param array $blocksCountByRow
 * @return int|null
 */
function findTheHighestBlockNumberBeingIncremental(array $blocksCountByRow): ?int {
    if (count($blocksCountByRow) === 0) {
        return null;
    }

    $previousNumber = null;

    foreach ($blocksCountByRow as $rowBlockCount) {
        if ($previousNumber !== null && $previousNumber > $rowBlockCount) {
            return $previousNumber;
        }
        $previousNumber =  $rowBlockCount;
    }
    return $previousNumber;
}