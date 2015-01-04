
class CalculatorApp {

	def compute(String operator, int op1, int op2) {
		switch (operator) {
			case '+': return op1 + op2
			case '/': return op1 / op2
			case '-': return op1 - op2
			case '*': return op1 * op2
		}
		return null
	}
}


