package com.fazzaro.advent.reports

import kotlin.math.abs

class Report(input: String) {
    val levels: List<Int> = parse(input)

    private fun parse(input: String) = input.split(" ").map {
        it.toInt()
    }.toList()
}

open class Reactor(protected val report: Report) {
    fun isSafe(): Boolean {
        return (test { it.isIncreasing() } || test { it.isDecreasing() })
                && test { it.isWithin(3) }
    }

    protected open fun test(condition: (pair:Pair<Int, Int>) -> Boolean): Boolean {
        return report.levels.zipWithNext().all { condition(it) }
    } 
}

class ProblemDampenedReactor(report: Report) : Reactor(report) {
    override fun test(condition: (pair: Pair<Int, Int>) -> Boolean): Boolean {
        return report.levels.any { level ->
            report.levels.filter{ it != level }.zipWithNext().all { condition(it) }
        }
    }
}

fun Pair<Int, Int>.isWithin(span: Int) = abs(this.first - this.second) <= span
fun Pair<Int, Int>.isDecreasing() = this.second < this.first
fun Pair<Int, Int>.isIncreasing() = this.second > this.first

