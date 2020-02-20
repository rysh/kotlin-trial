fun OtherProducts(arr: Array<Int>): String {

    // code goes here
    return arr.mapIndexed{idx,n ->
        val list = arr.toMutableList()
        list.removeAt(idx)
        list.reduce{ a, b -> a*b}
    }.joinToString(separator = "-");
}
