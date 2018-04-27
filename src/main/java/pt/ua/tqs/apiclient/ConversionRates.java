package pt.ua.tqs.apiclient;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ConversionRates {
	public Map<String, Double> quotes = new HashMap<>();

	public Map<String, Double> getQuotes() {
		return quotes;
	}

	public void setQuotes(Map<String, Double> conversions) {
		this.quotes = conversions;
	}
	
	
}
