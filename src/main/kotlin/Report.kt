import kotlin.math.abs

class Report(input: String) {
    val levels: List<Int> = parse(input)

    private fun parse(input: String) = input.split(" ").map {
        it.toInt()
    }.toList()

    fun isSafe(): Boolean {
        return (levels.zipWithNext().all { it.isIncreasing() } 
            || levels.zipWithNext().all { it.isDecreasing()}) 
            && levels.zipWithNext().all { it.isWithin(3) }
    }
}

fun Pair<Int, Int>.isWithin(span: Int) = abs(this.first - this.second) <= span
fun Pair<Int, Int>.isDecreasing() = this.second < this.first
fun Pair<Int, Int>.isIncreasing() = this.second > this.first

