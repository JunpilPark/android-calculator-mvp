package edu.nextstep.camp.calculator.domain

class MemoryCalculateStorage(history: List<HistoryItem> = emptyList()) : CalculateStorage {
    private val _history: MutableList<HistoryItem> = history.toMutableList()
    override val history: List<HistoryItem>
        get() = _history.toList()

    override fun save(formula: Expression, result: Expression) {
        _history.add(HistoryItem(formula, result))
    }
}