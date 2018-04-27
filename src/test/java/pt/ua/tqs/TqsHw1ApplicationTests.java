package pt.ua.tqs;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pt.ua.tqs.controllers.ConversionFormController;
import pt.ua.tqs.resources.ConvertResource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TqsHw1ApplicationTests {
	@Autowired
    private ConvertResource convertResource;
	
	@Autowired
	private CachedDataWrapper cachedData;
	
	@Autowired
	private ConversionFormController controller;
	
	@Test
	public void contextLoads() {
		// check if controllers have been mapped
		Assertions.assertThat(controller).isNotNull();
		Assertions.assertThat(convertResource).isNotNull();
		
		// check if currency data is retrieved from external API and stored in cache
		Assertions.assertThat(cachedData.getCurrencies()).isNotNull();
		Assertions.assertThat(cachedData.getCurrencies()).isNotEmpty();
		Assertions.assertThat(cachedData.getConversions()).isNotNull();
		Assertions.assertThat(cachedData.getConversions()).isNotEmpty();
	}

}
