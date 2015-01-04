import org.jspresso.contrib.tmar.core.Tmar4JUnit
import org.jspresso.contrib.tmar.core.TmarDataSequence

import groovy.util.logging.Slf4j
import org.junit.Test

@Slf4j
class ConverterTest extends Tmar4JUnit {

	@Test
	void test_text() {
		def testTmar = getData('text')
	    eachIteration(testTmar){ tmar ->
			tmar.result = new ConverterApp().convert(tmar.text, tmar.to) 
	    }
	}
}


