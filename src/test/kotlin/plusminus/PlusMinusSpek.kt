package plusminus

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on
import org.jetbrains.spek.subject.SubjectSpek
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PlusMinusSpek : SubjectSpek<(Array<Int>) -> Triple<Double, Double, Double>>({
    describe("getting counts of positives, negatives and zero values") {
        subject { ::plusMinusZeros }
        var array: Array<Int>
        fun rangeWithPrecision(s : Double, p : Double) = (s..s+p)

        on("empty array") {
            array = emptyArray()

            it("should return three zeros") {
                assertEquals(Triple(0.0, 0.0, 0.0), subject(array))
            }
        }

        on("positive array") {
            array = arrayOf(1, 2, 3)

            it("should return 1.0 as first parameter") {
                assertEquals(1.0, subject(array).first)
            }
        }

        on("negative array") {
            array = arrayOf(-1, -2, -3)

            it("should return 1.0 as second parameter") {
                assertEquals(1.0, subject(array).second)
            }
        }

        on("array of zeros") {
            array = arrayOf(0, 0, 0)

            it("should return 1.0 as third parameter") {
                assertEquals(1.0, subject(array).third)
            }
        }

        on("custom array",
                data(arrayOf(-4, 3, -9, 0, 4, 1), expected = Triple(0.499999, 0.333333, 0.166666)))
        { array, expected ->
            val results = subject(array)
            val precision = 0.000001

            it("should return parameters with sum of them equals to 1") {
                assertTrue { rangeWithPrecision(0.999999, precision).contains(results.toList().sum()) }
            }

            it("should return percentages of positive values in the array") {
                assertTrue { rangeWithPrecision(results.first, precision).contains(results.first) }
            }

            it("should return percentages of negative values in the array") {
                assertTrue { rangeWithPrecision(results.second, precision).contains(results.second) }
            }

            it("should return percentages of zero values in the array") {
                assertTrue { rangeWithPrecision(results.third, precision).contains(results.third) }
            }
        }
    }
})