package verybigsum

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import kotlin.test.assertEquals

object VeryBigSumSpec : SubjectSpek<(Array<Int>) -> Long>({
    describe("a very big sum calculation") {
        subject { ::sum }

        on("ints which will overflow integer on sum") {
            val s = subject(arrayOf(1_000_000_001, 1_000_000_002, 1_000_000_003, 1_000_000_004, 1_000_000_005))

            it("should return long value") {
                assertEquals(5_000_000_015, s)
            }
        }

        on("small ints") {
            val s = subject(arrayOf(1, 2, 3))

            it("should also return long value") {
                assertEquals(6, s)
            }
        }
    }
})