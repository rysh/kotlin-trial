fun SwitchSort(arr: Array<Int>): Int {
    val sorted: IntArray = arr.toIntArray()
    sorted.sort()
    val sorting = arr.toIntArray()
    var count = 0
    outer@ while (!isSorted(sorting, sorted)) {
        sorting.forEachIndexed {idx, num ->
            if (sorted[idx] != sorting[idx]) {
                val idx2 = sorted.lastIndexOf(sorting[idx])
                swap(sorting, idx, idx2)
                count+=1
                return@forEachIndexed
            }
        }

    }
    return count
}

fun isSorted(arr1: IntArray, arr2: IntArray) = arr1.contentEquals(arr2)

fun swap(arr1: IntArray, idx1:Int, idx2:Int): IntArray {
    val value1 = arr1[idx1]
    val value2 = arr1[idx2]
    arr1[idx1] = value2
    arr1[idx2] = value1
    return arr1
}
