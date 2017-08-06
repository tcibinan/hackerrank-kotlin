package staircase

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on

import org.junit.Assert.*
import java.util.*

object StaircaseSpec : Spek({
    describe("a staircase") {
        val getStaircase = ::getStaircase
        var staircase : String

        on("size = 0") {
            staircase = getStaircase(0)
            it("prints nothing") {
                assertTrue(staircase.isEmpty())
            }
        }

        on("size = 1") {
            staircase = getStaircase(1)
            it("prints single stair") {
                assertEquals(staircase, "#")
            }
        }

        on("size > 1") {
            staircase = getStaircase(3)
            it("prints concrete staircase") {
                assertEquals(staircase, "  #\n ##\n###")
            }
        }
    }
})