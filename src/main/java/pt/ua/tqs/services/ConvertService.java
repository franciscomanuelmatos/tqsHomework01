package pt.ua.tqs.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.ua.tqs.CachedDataWrapper;

@Service
public class ConvertService {
	@Autowired
	private CachedDataWrapper cachedData;
	
	public Double convertFromCurrencyToAnother(String cur1, String cur2, 
			Double amount) {
		if(cur1.equals(cur2))
			return amount;
		if(cur1.equals("USD"))
			return this.convertUSDToCurrency(cur2, amount);
		if(cur2.equals("USD"))
			return this.convertCurrencyToUSD(cur1, amount);
		
		return this.convertCurrencies(cur1, cur2, amount);
	}
	
	private Double convertUSDToCurrency(String currency, Double amount) {
		Double quote = cachedData.getConversions().get("USD"+currency);
		return amount * quote;
	}
	
	private Double convertCurrencyToUSD(String currency, Double amount) {
		Double quote = cachedData.getConversions().get("USD"+currency);
		return amount / quote;
	}
	
	private Double convertCurrencies(String cur1, String cur2, Double amount) {
		Map<String, Double> quotes = cachedData.getConversions();
		Double usdToCur1 = quotes.get("USD"+cur1);
		Double amountInUsd = amount / usdToCur1;
		Double usdToCur2 = quotes.get("USD"+cur2);
		Double amountInCur2 = amountInUsd * usdToCur2; 
		return amountInCur2;
	}
}
