package edu.nextstep.camp.calculator

import edu.nextstep.camp.calculator.domain.Calculator
import edu.nextstep.camp.calculator.domain.Expression
import edu.nextstep.camp.calculator.domain.Operator

class MainPresenter(
    private val view: MainContract.View,
    private val calculator: Calculator = Calculator(),
    private var expression: Expression = Expression.EMPTY
): MainContract.Presenter {

    override fun addToExpression(operand: Int) {
        expression += operand
        view.showExpression(expression)
    }

    override fun addToExpression(operator: Operator) {
        expression += operator
        view.showExpression(expression)
    }

    override fun calculate() {
        val calculatedValue = calculator.calculate(expression.toString())
        calculatedValue?.let {
            expression = Expression.EMPTY + it
        }
        view.showExpression(expression)
    }

    override fun delete() {
        expression = expression.removeLast()
        view.showExpression(expression)
    }

}