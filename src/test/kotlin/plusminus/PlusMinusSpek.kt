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
        fun rangeWithPrecision(s: Double, p: Double) = (s..s + p)

        on("empty array") {
            array = emptyArray()

            it("should return three zeros") {
                assertEquals(Triple(0.0, 0.0, 0.0), subject(array))
            }
        }

        on("array of %s",
                data("-4, 3, -9, 0, 4, 1", arrayOf(-4, 3, -9, 0, 4, 1), expected = Triple(0.499999, 0.333333, 0.166666)),
                data("0, 0, 0", arrayOf(0, 0, 0), expected = Triple(0.0, 0.0, 1.0)),
                data("-1, -2, -3", arrayOf(-1, -2, -3), expected = Triple(0.0, 1.0, 0.0)),
                data("1, 2, 3", arrayOf(1, 2, 3), expected = Triple(1.0, 0.0, 0.0)))
        { _, array, expected ->
            val results = subject(array)
            val precision = 0.000001

            it("should return parameters with sum of them equals to 1") {
                assertTrue { rangeWithPrecision(0.999999, precision).contains(results.toList().sum()) }
            }

            it("should return ~${Math.round(results.first * 100)}% for positive values") {
                assertTrue { rangeWithPrecision(expected.first, precision).contains(results.first) }
            }

            it("should return ~${Math.round(results.second * 100)}% for negative values") {
                assertTrue { rangeWithPrecision(expected.second, precision).contains(results.second) }
            }

            it("should return ~${Math.round(results.third * 100)}% for zero values") {
                assertTrue { rangeWithPrecision(expected.third, precision).contains(results.third) }
            }
        }
    }
})