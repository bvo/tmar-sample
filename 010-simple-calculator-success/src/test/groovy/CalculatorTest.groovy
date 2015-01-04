import org.jspresso.contrib.tmar.core.Tmar4JUnit
import org.jspresso.contrib.tmar.core.TmarDataSequence

import groovy.util.logging.Slf4j
import org.junit.Test

@Slf4j
class CalculatorTest extends Tmar4JUnit {

	@Test
	void test_addition() {
	    eachIteration('addition'){ tmar ->
	      tmar.results = new CalculatorApp().addition(tmar.op1, tmar.op2)
	    }
	}
}


