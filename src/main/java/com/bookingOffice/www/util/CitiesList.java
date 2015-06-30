package com.bookingOffice.www.util;

import java.util.Map;
import java.util.TreeMap;

public class CitiesList {
	Map<String,String> cities = new TreeMap<String, String>();

	public CitiesList() {
		cities.clear();
		cities.put("Kyiv", "KBP");
		cities.put("Rotterdam","RTM");
		cities.put("New York","JFK");
		cities.put("Kabul", "KBL");
		cities.put("Rostov-on-Don","RDN");
		cities.put("Moskow","DME");
	}

	/**
	 * @return the cities
	 */
	public Map<String, String> getCities() {
		return cities;
	}

	/**
	 * @param cities the cities to set
	 */
	public void setCities(Map<String, String> cities) {
		this.cities = cities;
	}

	

}
