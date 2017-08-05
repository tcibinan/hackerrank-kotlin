package diagonaldifference

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

object DiagonalDifferenceSpec : Spek({
    describe("getting a difference between diagonals of the matrix") {
        val getDiff = ::diagonalAbsoluteDifference
        var matrix: Array<Array<Int>>

        on("empty matrix") {
            matrix = emptyArray()

            it("should return 0") {
                assertEquals(0, getDiff(matrix))
            }
        }

        on("1x1 matrix") {
            matrix = arrayOf(arrayOf(5))

            it("should return 0") {
                assertEquals(0, getDiff(matrix))
            }
        }

        on("3x3 matrix") {
            matrix =
                    arrayOf(
                            arrayOf(11, 2, 4),
                            arrayOf(4, 5, 6),
                            arrayOf(10, 8, -12))

            it("should return concrete result") {
                assertEquals(15, getDiff(matrix))
            }
        }
    }
})