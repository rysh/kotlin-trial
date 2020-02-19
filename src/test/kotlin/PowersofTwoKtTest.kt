import org.junit.Test

import org.junit.Assert.*

class PowersofTwoKtTest {

    @Test
    fun powersofTwo() {
        assertEquals(true, PowersofTwo(4))
        assertEquals(false, PowersofTwo(124))


        assertEquals(true, PowersofTwo(2))
        assertEquals(true, PowersofTwo(4))
        assertEquals(false, PowersofTwo(6))
        assertEquals(false, PowersofTwo(12))
        assertEquals(true, PowersofTwo(8))
        assertEquals(false, PowersofTwo(9))
        assertEquals(true, PowersofTwo(128))
        assertEquals(true, PowersofTwo(1024))
        assertEquals(true, PowersofTwo(2048))
        assertEquals(false, PowersofTwo(5000))
    }
}