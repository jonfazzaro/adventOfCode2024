package com.fazzaro.advent.reports

import kotlin.math.abs

class Report(input: String) {
    val levels: List<Int> = parse(input)

    private fun parse(input: String) = input.split(" ").map {
        it.toInt()
    }.toList()
}

open class Reactor(protected val report: Report) {
    open fun isSafe(): Boolean {
        return isSafe(report.levels)
    }

    protected fun isSafe(levelsToTest: List<Int>) =
        ((levelsToTest.zipWithNext().all { it.isIncreasing() } || levelsToTest.zipWithNext().all { it.isDecreasing() })
                && levelsToTest.zipWithNext().all { it.isWithin(3) })
}

class ProblemDampenedReactor(report: Report) : Reactor(report) {
    override fun isSafe(): Boolean {
        return withRemoved(report.levels).any {
            return@any isSafe(it)
        }
    }

    private fun withRemoved(levels: List<Int>) = List(levels.size) { index -> levels.filterIndexed { i, _ -> index != i } }
}

fun Pair<Int, Int>.isWithin(span: Int) = abs(this.first - this.second) <= span
fun Pair<Int, Int>.isDecreasing() = this.second < this.first
fun Pair<Int, Int>.isIncreasing() = this.second > this.first

