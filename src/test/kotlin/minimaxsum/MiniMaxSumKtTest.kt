package minimaxsum

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

import org.junit.Assert.*

object MiniMaxSumKtTest : Spek({
    describe("calculation min and max sums on numbers") {
        val miniMaxSum = ::miniMaxSum
        var nums: Array<Int>
        var minMaxPair: Pair<Long, Long>

        on("five equals numbers") {
            val number = 5
            minMaxPair = miniMaxSum(Array(5) { number })
            it("should return two sums equals to number*4") {
                assertEquals(Pair(number * 4L, number * 4L), minMaxPair)
            }
        }

        on("five zeros") {
            minMaxPair = miniMaxSum(Array(5) { 0 })
            it("should return two zeros") {
                assertEquals(Pair(0L, 0L), minMaxPair)
            }
        }

        on("five different numbers") {
            minMaxPair = minimaxsum.miniMaxSum(arrayOf(1, 2, 3, 4, 5))
            it("should return sum of 4 minumum values and 4 maximum values") {
                assertEquals(Pair(10L, 14L), minMaxPair)
            }
        }
    }
})