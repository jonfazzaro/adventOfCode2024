import kotlin.math.abs

class Locations(val list: List<Int>) {
    fun reconcile(other: Locations): Int {
        return list.sorted()
            .zip(other.list.sorted()) { a, b -> abs(a - b) }
            .sum()
    }

    fun similarity(other: Locations): Int {
        return list.sumOf {
            it * other.list.count { o -> o == it }
        }
    }


}
