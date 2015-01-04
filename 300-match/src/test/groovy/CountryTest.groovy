import org.jspresso.contrib.tmar.core.Tmar4JUnit
import org.jspresso.contrib.tmar.core.TmarDataSequence

import groovy.util.logging.Slf4j
import org.junit.Test

@Slf4j
class CountryTest extends Tmar4JUnit {

	@Test
	void test_match() {
		def testTmar = getData('match')
	    eachIteration(testTmar){ tmar ->
			CountryApp app = new CountryApp()
			app.countries = createSimpleData(tmar.table.countries)
			tmar.results = ['country':app.countryForLanguage(tmar.language)]
	    }
	}
	  
	  
	  protected List createSimpleData (Map map, Class clazz = HashMap) {
	    if (! map) {
	      return []
	    }

	    Set keys = map.keySet()
	    int size = map[keys.first()].size()

	    List list = []
	    size.times { int i ->
	      def object = clazz.newInstance()
	      keys.each {
	        try {
	          object[it] = map[it][i]
	        }
	        catch (Exception e) {
	          throw new RuntimeException("impossible to affect `${map[it][i]}' of type `${map[it][i]?.class?.simpleName}' for object `$object' and property `$it'", e)
	        }
	      }
	      list << object
	    }

	    return list
	  }
}