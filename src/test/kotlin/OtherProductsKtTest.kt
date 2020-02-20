import org.junit.Test

import org.junit.Assert.*

class OtherProductsKtTest {

    @Test
    fun otherProducts() {
        assertEquals("12-3-4", OtherProducts(arrayOf(1,4,3)))
        assertEquals("12-36-18-6", OtherProducts(arrayOf(3,1,2,6)))


        assertEquals("12-36-18-6", OtherProducts(arrayOf(3,1,2,6)))
        assertEquals("120-60-40-30-24", OtherProducts(arrayOf(1,2,3,4,5)))
        assertEquals("12-3-4", OtherProducts(arrayOf(1,4,3)))
        assertEquals("12-36-18-6", OtherProducts(arrayOf(3,1,2,6)))
        assertEquals("1-1-1", OtherProducts(arrayOf(1,1,1)))
        assertEquals("3-2-6-6", OtherProducts(arrayOf(2,3,1,1)))
        assertEquals("8-8-8-8", OtherProducts(arrayOf(2,2,2,2)))
        assertEquals("6-27-18-54", OtherProducts(arrayOf(9,2,3,1)))
        assertEquals("1368-342-228-72-456", OtherProducts(arrayOf(1,4,6,19,3)))
        assertEquals("1024-512-256-128-64", OtherProducts(arrayOf(1,2,4,8,16)))
        assertEquals("6-1", OtherProducts(arrayOf(1,6)))
    }
}