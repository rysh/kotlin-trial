import org.junit.Test

import org.junit.Assert.*

class ShortestPathKtTest {

    @Test
    fun createGraphTest() {
        assertEquals("[B, C]", createGraph(arrayOf("5","A","B","C","D","F","A-B","A-C","B-C","C-D","D-F")).toString())

    }
    @Test
    fun shortestPath() {
        assertEquals("A-C-D-F", ShortestPath(arrayOf("5","A","B","C","D","F","A-B","A-C","B-C","C-D","D-F")))
    }
}