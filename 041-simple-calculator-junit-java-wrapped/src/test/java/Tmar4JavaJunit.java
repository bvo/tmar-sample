import groovy.lang.Closure;

import org.jspresso.contrib.tmar.core.Tmar4JUnit;
import org.jspresso.contrib.tmar.core.TmarDataSequence;
import org.junit.Test;


public class Tmar4JavaJunit extends Tmar4JUnit {

	protected void eachIteration (String tmarAccessName, final JavaTmar javaTmar) {
		TmarDataSequence testTmar = (TmarDataSequence) getData(tmarAccessName);
		eachIteration(testTmar, new Closure<Object>(testTmar) {
			public Object doCall(TmarDataSequence tmar) {
				javaTmar.setTmarData(tmar);
				javaTmar.test();
				return null;
			}
		});
	}
}