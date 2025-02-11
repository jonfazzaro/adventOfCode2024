package com.fazzaro.advent.reports

class DampeningReport(input: String) : Report(input) {
    override fun test(condition: (pair: Pair<Int, Int>) -> Boolean): Boolean {
        return levels.any { level ->
            levels.filter{ it != level }.zipWithNext().all { condition(it) }
        }
    }
}
