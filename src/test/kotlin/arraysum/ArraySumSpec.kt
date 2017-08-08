package arraysum

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.Assert.*

object ArraySumSpec : SubjectSpek<(Array<Int>) -> Int>({
    describe("a sum function") {
        subject { ::sum }

        on("non empty array") {
            val sum = subject(arrayOf(5, 6, 7))
            it("should return sum of elements") {
                assertEquals(sum, 18)
            }
        }

        on("empty array") {
            val sum = subject(arrayOf())
            it("should return 0") {
                assertEquals(sum, 0)
            }
        }
    }
})