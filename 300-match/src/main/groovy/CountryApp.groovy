
class CountryApp {
	
	List<Map> countries = []

	List<String> countryForLanguage(String language) {
		return countries.findResults { it.language == language ? it.country : null }
	}
}


