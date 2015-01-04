import groovy.lang.Closure;

import org.jspresso.contrib.tmar.core.Tmar4JUnit;
import org.jspresso.contrib.tmar.core.TmarDataSequence;
import org.junit.Test;
import business.CalculatorApp;

public class CalculatorTest extends Tmar4JUnit {

	@Test
	public void test_addition() {
		TmarDataSequence testTmar = (TmarDataSequence) getData("addition");
		eachIteration(testTmar, new Closure<Object>(testTmar) {
			public Object doCall(TmarDataSequence tmar) {
				int op1 = (Integer) tmar.propertyMissing("op1");
				int op2 = (Integer) tmar.propertyMissing("op1");
				int results = new CalculatorApp().addition(op1, op2);
				tmar.propertyMissing("results", results);
				return null;
			}
		});
	}
}
