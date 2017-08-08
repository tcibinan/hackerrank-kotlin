package diagonaldifference

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on
import org.jetbrains.spek.subject.SubjectSpek
import kotlin.test.assertEquals

object DiagonalDifferenceSpec : SubjectSpek<(Array<Array<Int>>) -> Int>({
    describe("getting a difference between diagonals of the matrix") {
        subject { ::diagonalAbsoluteDifference }
        var matrix: Array<Array<Int>>
        val dataWithMatrices = arrayOf(
                data(1, arrayOf(arrayOf(5)), 0),
                data(3, arrayOf(arrayOf(11, 2, 4), arrayOf(4, 5, 6), arrayOf(10, 8, -12)), 15)
        )

        on("empty matrix") {
            matrix = emptyArray()

            it("should return 0") {
                assertEquals(0, subject(matrix))
            }
        }
        on("%1\$s x %1\$s",
                *dataWithMatrices) { _, matrix, expected ->

            it("should return $expected") {
                assertEquals(expected, subject(matrix))
            }
        }
    }
})