package com.fazzaro.advent.reports

import kotlin.math.abs

open class Report(input: String) {
    val levels: List<Int> = parse(input)

    private fun parse(input: String) = input.split(" ").map {
        it.toInt()
    }.toList()

    fun isSafe(): Boolean {
        return (test { it.isIncreasing() } || test { it.isDecreasing() })
            && test { it.isWithin(3) }
    }
    
    protected open fun test(condition: (pair:Pair<Int, Int>) -> Boolean): Boolean {
        return levels.zipWithNext().all { condition(it) }
    }
}

fun Pair<Int, Int>.isWithin(span: Int) = abs(this.first - this.second) <= span
fun Pair<Int, Int>.isDecreasing() = this.second < this.first
fun Pair<Int, Int>.isIncreasing() = this.second > this.first

