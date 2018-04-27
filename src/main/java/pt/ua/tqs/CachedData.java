package pt.ua.tqs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import pt.ua.tqs.apiclient.CurrencyApiClient;

public class CachedData {
	private static Map<String, Double> conversions = new HashMap<>();
	private static Set<String> currencies = new HashSet<>();
	private static long previous = System.currentTimeMillis(); 
	
	public static Map<String, Double> getConversions() {
		long currentTimestamp = System.currentTimeMillis();
		long difference = Math.abs(currentTimestamp - previous);

		if (difference > 1 * 60 * 1000) {
		    previous = currentTimestamp;
		    refreshCache();
		}
		
		return conversions;
	}
	public static void setConversions(Map<String, Double> conversions) {
		CachedData.conversions = conversions;
	}
	public static Set<String> getCurrencies() {
		return currencies;
	}
	public static void setCurrencies(Set<String> currencies) {
		CachedData.currencies = currencies;
	}
	
	public static void refreshCache() {
		CurrencyApiClient apiClient = new CurrencyApiClient();
		CachedData.setConversions(apiClient.getConversionRates());
	}
}
