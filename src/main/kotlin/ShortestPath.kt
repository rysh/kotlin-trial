fun ShortestPath(strArr: Array<String>): String {
    val temp = createGraph(strArr)
    val startNode = temp.first
    val goal = temp.second

    queue.add(startNode)
    return search(goal)!!.joinToString(separator = "-");

}

fun createGraph(strArr: Array<String>): Pair<Node, String> {
    var goal:String = ""
    val nodeCount = strArr[0].toInt()
    val startNode = Node(strArr[1])
    val nodes = mutableMapOf<String, Node>(startNode.name to startNode)
    for (i in 2..nodeCount) {
        val name = strArr[i]
        nodes[name] = Node(name)
        goal = name
    }
    for (i in nodeCount + 1 until strArr.size) {
        val names = strArr[i].split("-")
        val node0 = nodes[names[0]]!!
        val node1 = nodes[names[1]]!!
        node0.add(node1)
        node1.add(node0)
    }
    return Pair(startNode, goal)
}


class Node(val name:String){
    val route = mutableListOf<String>()
    val nodes = mutableListOf<Node>()
    fun add(n:Node) = nodes.add(n)

    override fun toString():String = "${nodes.map { it.name }}"
}

val knownNodes = mutableSetOf<String>()
var queue = mutableListOf<Node>()
fun search(goal: String): List<String>? {
    val curr:Node = queue.first()
    queue.removeAt(0)

    if (hasGoal(curr, goal)) {
        val route = curr.route
        route.add(curr.name)
        route.add(goal)
        return route
    }

    val nodes = curr.nodes.filter { !knownNodes.contains(it.name) }
    nodes.forEach{
        knownNodes.add(it.name)
        it.route.addAll(curr.route)
        it.route.add(curr.name)
    }
    queue.addAll(nodes)
    if (queue.isNotEmpty()) {
        search(goal)?.let { return it }
    }
    return null
}

private fun hasGoal(curr: Node, goal: String) = curr.nodes.find { it.name == goal } != null