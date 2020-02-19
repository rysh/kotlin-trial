import org.junit.Test

import org.junit.Assert.*

class SwitchSortKtTest {

    @Test
    fun isSortedTest() {
        assertEquals(true, isSorted(intArrayOf(1,2,3), intArrayOf(1,2,3)))
        assertEquals(false, isSorted(intArrayOf(2,1,3), intArrayOf(1,2,3)))
    }
    @Test
    fun swapTest() {
        assertArrayEquals(intArrayOf(1,2,3), swap(intArrayOf(3,2,1), 0,2))
    }
    @Test
    fun switchSortTest() {
        assertEquals(2, SwitchSort(arrayOf(3,1,2)))
        assertEquals(2, SwitchSort(arrayOf(1,3,4,2)))

        assertEquals(1, SwitchSort(arrayOf(1,2,4,3)))
        assertEquals(0, SwitchSort(arrayOf(1,2,3,4)))
        assertEquals(3, SwitchSort(arrayOf(3,4,2,1)))
        assertEquals(2, SwitchSort(arrayOf(1,3,4,2)))
        assertEquals(2, SwitchSort(arrayOf(3,1,2)))
        assertEquals(1, SwitchSort(arrayOf(2,1)))
        assertEquals(2, SwitchSort(arrayOf(4,3,2,1)))
        assertEquals(2, SwitchSort(arrayOf(5,4,3,2,1)))
        assertEquals(4, SwitchSort(arrayOf(5,3,4,1,2)))
        assertEquals(3, SwitchSort(arrayOf(5,4,3,1,2)))
    }
}