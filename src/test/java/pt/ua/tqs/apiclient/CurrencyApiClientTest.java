package pt.ua.tqs.apiclient;

import java.util.Map;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CurrencyApiClientTest {
	@Autowired
	private CurrencyApiClient apiClient;
	
	@Test
	public void getCurrencyList() {
		Set<String> currencyList = apiClient.getCurrencyList();
		
		Assertions.assertThat(currencyList).isNotNull();
		Assertions.assertThat(currencyList).isNotEmpty();
		Assertions.assertThat(currencyList).contains("USD");
	}
	
	@Test
	public void getConversionRates() {
		Map<String, Double> conversionRates = apiClient.getConversionRates();
		
		Assertions.assertThat(conversionRates).isNotNull();
		Assertions.assertThat(conversionRates).isNotEmpty();
		Assertions.assertThat(conversionRates.keySet()).contains("USDEUR");
		Assertions.assertThat(conversionRates.get("USDEUR")).isNotNull();
	}
}
