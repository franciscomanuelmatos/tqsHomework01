package pt.ua.tqs.apiclient;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrencyList {
	private Map<String, String> currencies = new HashMap<>();

	public Map<String, String> getCurrencies() {
		return currencies;
	}

	public void setCurrencies(Map<String, String> currencies) {
		this.currencies = currencies;
	}
	
	
}
