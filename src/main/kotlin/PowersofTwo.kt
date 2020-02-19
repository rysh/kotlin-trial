
fun PowersofTwo(num: Int): Boolean {
    if (memo.contains(num)) {
        return true
    }

    while (latest < num) {
        latest *= 2
        memo.add(latest)
    }
    return latest == num;

}
val memo = mutableSetOf<Int>(2)
var latest = 2