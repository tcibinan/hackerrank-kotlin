package staircase

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.data_driven.data
import org.jetbrains.spek.data_driven.on
import org.jetbrains.spek.subject.SubjectSpek

import org.junit.Assert.*
import java.util.*

class StaircaseSpec : SubjectSpek<(Int) -> String>({
    describe("a staircase") {
        subject { ::getStaircase }
        var staircase : String

        on("0 stairs") {
            staircase = subject(0)
            it("prints nothing") {
                assertTrue(staircase.isEmpty())
            }
        }

        on("1 stair") {
            staircase = subject(1)
            it("prints single stair") {
                assertEquals(staircase, "#")
            }
        }

        on("%d stairs",
                data(2, " #\n##"),
                data(3, "  #\n ##\n###")) { stairs, expected ->
            staircase = subject(stairs)
            it("prints $stairs-stair staircase") {
                assertEquals(staircase, expected)
            }
        }
    }
})