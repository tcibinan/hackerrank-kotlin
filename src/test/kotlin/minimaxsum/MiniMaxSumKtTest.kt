package minimaxsum

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

import org.junit.Assert.*

object MiniMaxSumKtTest : Spek({
    describe("calculation mini max sum on numbers") {
        val miniMaxSum = ::miniMaxSum
        var nums : Array<Int>

        on("five equals numbers") {
            val number = 5
            nums = Array(5) {number}
            it("should return this number*8") {
                assertEquals(number*8L, miniMaxSum(nums))
            }
        }

        on("five zeros") {
            nums = Array(5) {0}
            it("should return zero") {
                assertEquals(0L, miniMaxSum(nums))
            }
        }

        on("five different numbers") {
            nums = arrayOf(1, 2, 3, 4, 5)
            val minSum = 10L
            val maxSum = 14L
            it("should return sum of 4 minumum values and 4 maximum values") {
                assertEquals(minSum+maxSum, miniMaxSum(nums))
            }
        }
    }
})