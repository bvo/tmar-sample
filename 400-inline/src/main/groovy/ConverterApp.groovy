
class ConverterApp {
	
	String convert(String text, String to) {
		switch (to) {
			case 'uppercase': return text.toUpperCase()
			case 'lowercase': return text.toLowerCase()
		}
	}
}


