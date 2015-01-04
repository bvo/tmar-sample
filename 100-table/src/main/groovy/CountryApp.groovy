
class CountryApp {
	
	List<Map> countries = []

	boolean exists(String code) {
		return null != countries.find{ it.code == code }
	}
}


