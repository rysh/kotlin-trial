import org.junit.Test

import org.junit.Assert.*

class ShortestPathKtTest {

    @Test
    fun createGraphTest() {
        assertEquals("A [B, C]", createGraph(arrayOf("5","A","B","C","D","F","A-B","A-C","B-C","C-D","D-F")).first.toString())

        val node = createGraph(arrayOf("3","A","B","C","B-C","A-B")).first
        assertEquals("A [B]",node.toString())
        assertEquals("B [C, A]",node.nodes.first().toString())
        assertEquals("C [B]",node.nodes.first().nodes.first().toString())

    }
    @Test
    fun shortestPath() {
        assertEquals("A-C-D-F", ShortestPath(arrayOf("5","A","B","C","D","F","A-B","A-C","B-C","C-D","D-F")))

        assertEquals("A-B-C", ShortestPath(arrayOf("3","A","B","C","B-C","A-B")))
        assertEquals("A-Z-Y", ShortestPath(arrayOf("5","A","B","C","Z","Y","B-C","A-B","A-Z","C-Y","Z-Y")))
        assertEquals("A-B-C-Q", ShortestPath(arrayOf("6","A","B","C","Z","Y","Q","B-C","A-B","A-Z","C-Y","Z-Y","C-Q")))
        assertEquals("Z-Y-C-Q", ShortestPath(arrayOf("6","Z","B","C","A","Y","Q","B-C","A-B","A-Z","C-Y","Z-Y","C-Q")))
        assertEquals("c-s-h-d-m", ShortestPath(arrayOf("5","c","h","d","s","m","c-s","s-h","d-m","h-d")))
        assertEquals("-1", ShortestPath(arrayOf("2","First Street","Third Street")))
        assertEquals("-1", ShortestPath(arrayOf("7","D","A","N","I","E","L","B","D-A","A-N","E-B","E-L")))
        assertEquals("C-D-E-F", ShortestPath(arrayOf("7","C","B","A","D","E","G","F","A-B","B-E","E-G","C-D","D-B","D-E","E-F")))
        assertEquals("Z-A-R-E", ShortestPath(arrayOf("9","Z","B","C","D","R","A","Y","Q","E","A-Z","A-R","Z-Y","Z-C","C-B","Y-Q","Q-D","D-E","R-E")))
        assertEquals("N1-N2-N5", ShortestPath(arrayOf("5","N1","N2","N3","N4","N5","N1-N3","N3-N4","N4-N5","N5-N2","N2-N1")))

    }
}