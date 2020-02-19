import org.junit.Test

import org.junit.Assert.*

class OptimalAssignmentsKtTest {

    @Test
    fun optimalAssignmentsTest() {
        assertEquals("(1-1)(2-2)(3-3)",OptimalAssignments(arrayOf("(1,2,1)","(4,1,5)","(5,2,1)")))
    }
}