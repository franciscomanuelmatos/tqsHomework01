package pt.ua.tqs;

import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CachedDataWrapper {
	public Set<String> getCurrencies() {
		return CachedData.getCurrencies();
	}
	
	public Map<String, Double> getConversions() {
		return CachedData.getConversions();
	}
}
