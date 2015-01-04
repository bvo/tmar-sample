import groovy.lang.Closure;

import org.jspresso.contrib.tmar.core.Tmar4JUnit;
import org.jspresso.contrib.tmar.core.TmarDataSequence;
import org.junit.Test;

// Pour simplifier les closures en Java
public abstract class JavaTmar {

	public JavaTmar() {
	}

	TmarDataSequence tmar;
	
	public void setTmarData (TmarDataSequence tmar) {
		this.tmar = tmar;
	}

	public Object doCall() {
		test();
		return null;
	}

	abstract void test();
	
	void set(String key, Object value) {
		tmar.propertyMissing(key, value);
	}
	
	// TODO each type…
	int getInt(String key) {
		return (Integer)tmar.propertyMissing(key);
	}
}
