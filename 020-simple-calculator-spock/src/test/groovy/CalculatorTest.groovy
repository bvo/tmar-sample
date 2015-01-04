import org.jspresso.contrib.tmar.core.Tmar

class CalculatorTest extends Tmar {

	def test_addition() {

	    when:
	    tmar.results = new CalculatorApp().addition(tmar.op1, tmar.op2)

	    then:
	    tmar.asserts()

	    where:
	    tmar << getData('addition')
	  }
}