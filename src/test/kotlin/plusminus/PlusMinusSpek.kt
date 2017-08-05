package plusminus

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object PlusMinusSpek : Spek({
    describe("getting counts of positives, negatives and zero values") {
        val plusMinusZeros = ::plusMinusZeros
        var array : Array<Int>

        on("empty array") {
            array = emptyArray()

            it("should return three zeros") {
                assertEquals(Triple(0.0,0.0,0.0), plusMinusZeros(array))
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
            array = arrayOf(0,0,0)

            it("should return 1.0 as third parameter") {
                assertEquals(1.0, plusMinusZeros(array).third)
            }
        }

        on("custom array") {
            array = arrayOf(-4, 3, -9, 0, 4, 1)

            it("should return parameters with sum of them equals to 1") {
                assertEquals(1.0, plusMinusZeros(array).toList().sum())
            }

            it("should return percentages of positive, negative and zero values in the array") {
                assertEquals(Triple(0.500000, 0.333333,0.166667), plusMinusZeros(array))
            }
        }
    }
})
