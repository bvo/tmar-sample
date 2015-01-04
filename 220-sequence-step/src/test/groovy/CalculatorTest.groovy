import org.jspresso.contrib.tmar.core.Tmar4JUnit
import org.jspresso.contrib.tmar.core.TmarDataSequence

import groovy.util.logging.Slf4j
import org.junit.Test

@Slf4j
class CalculatorTest extends Tmar4JUnit {

	@Test
	void test_addition() {
		def testTmar = getData('addition')
	    eachIteration(testTmar){ tmar ->
			tmar.results = new CalculatorApp().compute(tmar.step, tmar.op1, tmar.op2)
	    }
	}
}


