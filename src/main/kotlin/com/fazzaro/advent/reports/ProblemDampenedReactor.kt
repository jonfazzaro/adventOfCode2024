package com.fazzaro.advent.reports

class ProblemDampenedReactor(report: Report) : Reactor(report) {
    override fun isSafe(): Boolean {
        return withRemoved(report.levels).any {
            return@any isSafe(it)
        }
    }

    private fun withRemoved(levels: List<Int>) = List(levels.size) { index -> levels.filterIndexed { i, _ -> index != i } }
}