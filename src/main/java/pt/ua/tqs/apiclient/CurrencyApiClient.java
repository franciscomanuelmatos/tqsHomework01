package pt.ua.tqs.apiclient;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyApiClient {
	private final String ACCESS_KEY = "faa5d2d9995f17912f8a54302c7329c5";
	private final String CURRENCIES_URI = "http://apilayer.net/api/list" + 
			"?access_key=" + ACCESS_KEY;
	private final String QUOTES_URI = "http://apilayer.net/api/live" +
			"?access_key=" + ACCESS_KEY;
	
	public Set<String> getCurrencyList() {
		RestTemplate restTemplate = new RestTemplate();
		CurrencyList currencyList = restTemplate.getForObject(CURRENCIES_URI, 
				CurrencyList.class);
		return currencyList.getCurrencies().keySet();
	}
	
	public Map<String, Double> getConversionRates() {
		RestTemplate restTemplate = new RestTemplate();
		ConversionRates conversionRates = restTemplate.getForObject(QUOTES_URI, 
				ConversionRates.class);
		return conversionRates.getQuotes();
	}
}
