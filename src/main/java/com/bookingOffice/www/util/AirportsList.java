package com.bookingOffice.www.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Set;
import java.util.TreeMap;

public class AirportsList {
	TreeMap<String, String> airports = new TreeMap<>();

	public AirportsList() {
		airports.clear();
		try (BufferedReader in = new BufferedReader(new FileReader(
				"Airports.txt"));) {
			String txt = "";
			while ((txt = in.readLine()) != null) {
				txt = txt.replace("\uFEFF", "");
				String[] buf = txt.split("`");
				int len = buf.length;
				if (len > 0) {
					String key = buf[0];
					String value = null;
					if (len > 1) {
						value = buf[1];
					}
					airports.put(key, value);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the airports
	 */
	public TreeMap<String, String> getAirports() {
		return airports;
	}

	/**
	 * @param airports the airports to set
	 */
	public void setAirports(TreeMap<String, String> airports) {
		this.airports = airports;
	}

	public Set<String> getCitiesSet() {
		return airports.keySet();
	}
	
	public String getCity(String city) {
		return airports.get(city);
	}
	
	public Collection<String> getCities() {
		return airports.values();
	}
	
	
	public static void main(String[] args) {
		AirportsList airports = new AirportsList();
		Collection<String> cities = airports.getCities();
		for (String string : cities) {
			System.out.println(string);
		}
	}
	
}
