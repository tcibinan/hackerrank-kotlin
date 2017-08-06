package plusminus

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals
import kotlin.test.assertTrue

object PlusMinusSpek : Spek({
    describe("getting counts of positives, negatives and zero values") {
        val plusMinusZeros = ::plusMinusZeros
        var array: Array<Int>

        on("empty array") {
            array = emptyArray()

            it("should return three zeros") {
                assertEquals(Triple(0.0, 0.0, 0.0), plusMinusZeros(array))
            }
        }

        on("positive array") {
            array = arrayOf(1, 2, 3)

            it("should return 1.0 as first parameter") {
                assertEquals(1.0, plusMinusZeros(array).first)
            }
        }

        on("negative array") {
            array = arrayOf(-1, -2, -3)

            it("should return 1.0 as second parameter") {
                assertEquals(1.0, plusMinusZeros(array).second)
            }
        }

        on("array of zeros") {
            array = arrayOf(0, 0, 0)

            it("should return 1.0 as third parameter") {
                assertEquals(1.0, plusMinusZeros(array).third)
            }
        }

        on("custom array") {
            array = arrayOf(-4, 3, -9, 0, 4, 1)
            val (a, b, c) = plusMinusZeros(array)

            it("should return parameters with sum of them equals to 1") {
                assertTrue { (0.999999..1.0).contains(arrayOf(a, b, c).sum()) }
            }

            it("should return percentages of positive values in the array") {
                assertTrue { (0.499999..0.500000).contains(a) }
            }

            it("should return percentages of negative values in the array") {
                assertTrue { (0.333332..0.333334).contains(b) }
            }

            it("should return percentages of zero values in the array") {
                assertTrue { (0.166666..0.166667).contains(c) }
            }
        }
    }
})
