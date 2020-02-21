import kotlin.text.Regex

fun CityTraffic(strArr: Array<String>): String {
    //check()
    // code goes here
    val nodeList = strArr.map{createNode(it)}
    val keys = nodeList.map{it.population}.sorted()
    val nodes: Map<Int,City> = nodeList.map {it.population to it}.toMap()
    return keys.map{city ->
        val node = nodes[city]!!
        node.nextTowns.map{nt ->
            val ignore = node.nextTowns.toMutableSet()
            Pair(node.population, nodes[nt]!!.collect(ignore, nodes) - node.population)
        }.reduce{a,b -> if (a.second > b.second) a else b}
    }.map{p -> "${p.first}:${p.second}"}.joinToString(",")
}

class City(val population:Int, val nextTowns:Set<Int>) {
    override fun toString():String {
        return "${population}:${nextTowns}"
    }

    fun collect(ignore:MutableSet<Int>, nodes: Map<Int,City>):Int {
        ignore.add(population)

        val list = nextTowns.filter{!ignore.contains(it)}.map{ k ->
            nodes[k]!!.collect(ignore, nodes)
        }

        var ret = population
        if (!list.isEmpty()) {
            ret +=list.reduce{a,b->a+b}
        }
        return ret
    }
}


val p = Regex("""\[|\]""")
fun createNode(input:String):City {
    val a = input.split(":")
    val towns = a[1].replace(p, "").split(",").map{it.toInt()}.toSet()
    return City(a[0].toInt(),towns)
}
fun check() {
    val node = createNode("8:[7,38]")
    println(node)

    val nodes: Map<Int,City> = listOf(createNode("1:[2]"),createNode("2:[1]")).map {it.population to it}.toMap()
    val ignore = mutableSetOf<Int>()
    println(nodes[1]!!.collect(ignore, nodes))

}