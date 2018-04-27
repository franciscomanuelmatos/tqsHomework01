package pt.ua.tqs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pt.ua.tqs.apiclient.CurrencyApiClient;

@SpringBootApplication
public class TqsHw1Application implements CommandLineRunner {
	@Autowired
	private CurrencyApiClient apiClient;

	public static void main(String[] args) {
		SpringApplication.run(TqsHw1Application.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		CachedData.setCurrencies(apiClient.getCurrencyList());
		CachedData.setConversions(apiClient.getConversionRates());
	}
}
