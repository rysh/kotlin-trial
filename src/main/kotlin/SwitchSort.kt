fun SwitchSort(arr: Array<Int>): Int {

    val list = SwitchSortedList(arr.toList())
    list.sort()

    return list.count
}


class SwitchSortedList(val origin: List<Int>) {
    var count = 0
    class Node(val value:Int) {
        var next:Node? = null

        fun add(num: Int) {
            if (next == null) {
                next = Node(num)
            } else {
                next!!.add(num)
            }
        }
        fun min():Int {
            if (next == null) {
                return value;
            } else{
                val minNum = next!!.min()
                if (value <= minNum) {
                    return value
                } else {
                    return minNum
                }
            }
        }
        fun isSmall():Boolean {
            if (next == null) {
                return true
            }
            return min() >= value
        }

        fun print() {
            print("$value ")
            if (next != null) {
                next!!.print()
            } else {
                println("")
            }
        }

    }
    var node = Node(origin.first())
    init {
        for (n in origin.drop(1)) {
            node.add(n)
        }
    }

    fun sort() {
        var curr: Node? = node.next
        while (curr != null) {
            while (!isSmall(curr!!)) {
                stepForeword(curr)
                count+=1
            }
            curr = curr.next
//            else {
//                stepForeword(curr)
//                count += 1
//            }
        }
    }

    private fun isSmall(target: Node): Boolean {
        var curr: Node? = node
        while (curr != null && curr != target) {
            if (curr.value > target.value) {
                return false
            }
            curr = curr.next
        }
        return true
    }


    fun stepForeword(target: SwitchSortedList.Node) {
        if (node.next!!.value == target.value) {
            val temp = target.next
            node.next = temp
            target.next = node
            node = target
        } else {
            var prev = node
            var curr: Node? = node.next
            while (curr!!.next != null) {
                if (curr.next!!.value == target.value) {
                    val temp = target.next
                    target.next = curr
                    curr.next = temp
                    prev.next = target
                    break
                }
                prev = curr
                curr = curr.next
            }
        }
    }

    fun print() {
        node.print()
    }
}