import org.junit.Test;
import business.CalculatorApp;

public class CalculatorTest extends Tmar4JavaJunit {

	@Test
	public void test_division() {
		eachIteration("division", new JavaTmar() {
			public void test () {
				set("results", new CalculatorApp().division(getInt("op1"), getInt("op2")));
			}
		});
	}
}
