import org.jspresso.contrib.tmar.core.Tmar4JUnit
import org.jspresso.contrib.tmar.core.TmarDataSequence

import groovy.util.logging.Slf4j
import org.junit.Test

@Slf4j
class CountryTest extends Tmar4JUnit {

	@Test
	void test_exists() {
		def testTmar = getData('exists')
	    eachIteration(testTmar){ tmar ->
			CountryApp app = new CountryApp()
			for (Map c : tmar.map.countriesWithLabel.values()) {
				app.countries << c
			}
		    tmar.exists = app.exists(tmar.code)
	    }
	}
}