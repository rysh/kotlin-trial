import org.junit.Test

import org.junit.Assert.*

class SwitchSortKtTest {

    @Test
    fun switchSortTest() {
        assertEquals(2, SwitchSort(arrayOf(3,1,2)))
        assertEquals(2, SwitchSort(arrayOf(1,3,4,2)))
    }
}