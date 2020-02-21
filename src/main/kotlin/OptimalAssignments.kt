import kotlin.text.Regex

fun OptimalAssignments(strArr: Array<String>): String {
    //test()

    val matrix = strArr.toList().map {parse(it)}
    var candidate = Pair(Int.MAX_VALUE,listOf<Int>())

    for (list in permutation((0 until strArr.size).toList())) {
        var cost = list.mapIndexed{idx,pos -> matrix[idx][pos]}.reduce{a,b->a+b}
        if (candidate.first > cost) {
            candidate = Pair(cost,list)
        }
    }

    return candidate.second.mapIndexed{idx,num -> "(${idx + 1}-${num + 1})"}.joinToString(separator="");

}

val pattern = Regex(pattern = """\(|\)""")
fun parse(input:String):List<Int> {
    return input.replace(pattern,"").split(",").map{it.toInt()}
}
fun parseResult(result:List<Pair<Int,Int>>):String {
    val temp = result.map{p -> "(${p.first}-${p.second})"}
    return temp.joinToString(separator = "")
}

fun permutation(nums: List<Int>): List<List<Int>> {
    fun get(nums: List<Int>, to:List<Int>): List<Pair<List<Int>, List<Int>>> = nums.mapIndexed { idx,l ->
        val list = nums.toMutableList()
        list.removeAt(idx)
        val temp = to.toMutableList()
        temp.add(l)
        Pair(list, temp)
    }

    var list = listOf(Pair(nums, listOf<Int>()))
    for (i in 1..nums.size) {
        list = list.flatMap { pair -> get(pair.first, pair.second) }
    }
    return list.map{it.second}
}


fun test() {
    if(!parse("(1,2,3)").equals(listOf(1,2,3))) println("parse error")
    if(!parseResult(listOf(Pair(2,1),Pair(2,3))).equals("(2-1)(2-3)")) println("parseResult error")
}