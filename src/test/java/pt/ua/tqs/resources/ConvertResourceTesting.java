package pt.ua.tqs.resources;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import pt.ua.tqs.TqsHw1Application;
import pt.ua.tqs.services.ConvertService;

@RunWith(SpringRunner.class)
@SpringBootTest(
  webEnvironment = WebEnvironment.RANDOM_PORT,
  classes = TqsHw1Application.class)
@AutoConfigureMockMvc
public class ConvertResourceTesting {
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private ConvertService convertService;
	
	@InjectMocks
	private ConvertResource convertResource;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(convertResource)
        			.build();

    }
	
	@Test
	public void getCurrencyConversion() throws Exception {
		
		Mockito.when(this.convertService.convertFromCurrencyToAnother("USD", 
				"EUR", 1.0))
			.thenReturn(0.8);
		
		this.mockMvc.perform(MockMvcRequestBuilders.get("/api/conversions")
								.param("cur1", "USD")
								.param("cur2", "EUR")
								.param("amount", "1.0"))
		.andExpect(MockMvcResultMatchers.content().
				contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.content().string("0.8"))
		.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
}
