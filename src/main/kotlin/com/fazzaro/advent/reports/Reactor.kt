package com.fazzaro.advent.reports

import kotlin.math.abs

open class Reactor(protected val report: Report) {
    open fun isSafe(): Boolean {
        return isSafe(report.levels)
    }

    protected fun isSafe(levelsToTest: List<Int>) =
        ((levelsToTest.zipWithNext().all { it.isIncreasing() } || levelsToTest.zipWithNext().all { it.isDecreasing() })
                && levelsToTest.zipWithNext().all { it.isWithin(3) })

    private fun Pair<Int, Int>.isWithin(span: Int) = abs(this.first - this.second) <= span
    private fun Pair<Int, Int>.isDecreasing() = this.second < this.first
    private fun Pair<Int, Int>.isIncreasing() = this.second > this.first
}

