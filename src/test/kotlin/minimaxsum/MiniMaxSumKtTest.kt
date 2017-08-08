package minimaxsum

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on

import org.junit.Assert.*

class MiniMaxSumSpec : Spek({
    describe("calculation min and max sums") {

        val miniMaxSum = ::miniMaxSumFunctional

        on("array of five %s's",
                data(0, Pair(0L, 0L)),
                data(5, Pair(20L, 20L))
        ) { num, expected ->
            it("should return ${expected.first} as a mins and maxs sums") {
                assertEquals(expected, miniMaxSum(Array(5) { num }))
            }
        }

        on("array of different numbers: %s",
                data(arrayOf(1, 2, 3, 4, 5), Pair(10L, 14L)),
                data(arrayOf(5, 4, 3, 2, 1), Pair(10L, 14L)),
                data(arrayOf(5, 0, 0, 0, 0), Pair(0L, 5L)),
                data(arrayOf(5, 5, 5, 5, 10), Pair(20L, 25L))
        ) { array, expected ->
            it("should return ${expected.first} as a mins sum and ${expected.second} as a maxs sums") {
                assertEquals(expected, miniMaxSum(array))
            }
        }
    }
})