package pt.ua.tqs.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import pt.ua.tqs.CachedDataWrapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ConvertService.class, CachedDataWrapper.class})
public class ConvertServiceTest {
	@Autowired
	private ConvertService convertService;
	
	@MockBean
	private CachedDataWrapper cachedData;
	
	@Test
	public void  convertUSDToCurrencyTest() {
		Mockito.when(this.cachedData.getConversions())
			.thenReturn(Collections.singletonMap("USDEUR", 1.201));
		
		Double result = this.convertService.convertFromCurrencyToAnother("USD",
				"EUR", 1.0);
		Assertions.assertThat(result).isEqualTo(1.201);
	}
	
	@Test
	public void convertCurrencyToUSDTest() {
		Mockito.when(this.cachedData.getConversions())
		.thenReturn(Collections.singletonMap("USDEUR", 2.0));
		
		Double result = this.convertService.convertFromCurrencyToAnother("EUR",
				"USD", 1.0);
		Assertions.assertThat(result).isEqualTo(0.5);
	}
	
	@Test
	public void ConvertCurrenciesTest() {
		Map<String, Double> quotes = new HashMap<>();
		quotes.put("USDEUR", 0.5);
		quotes.put("USDCAD", 2.0);
		
		Mockito.when(this.cachedData.getConversions())
		.thenReturn(quotes);
		
		Double result = this.convertService.convertFromCurrencyToAnother("EUR",
				"CAD", 1.0);
		Assertions.assertThat(result).isEqualTo(4.0);
	}
	
	@Test
	public void convertSameCurrency() {
		Double result = this.convertService.convertFromCurrencyToAnother("EUR",
				"EUR", 1.0);
		Assertions.assertThat(result).isEqualTo(1.0);
	}
}
