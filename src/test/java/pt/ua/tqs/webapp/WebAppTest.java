package pt.ua.tqs.webapp;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@RunWith(SpringRunner.class)
public class WebAppTest {
	
    private WebDriver driver;
    private String base;
    
    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", 
        		"/home/chico/Programs/chromedriver");
        driver = new ChromeDriver();
        this.base = "http://localhost:" + 8080;
    }
	
	@Test
	public void WebAppTesting() throws Exception {
		driver.get(this.base + "/conversion");
		Thread.sleep(5000);
		
		Select inputSelection = new Select(driver.findElement(By.id("inputCurrency")));
		inputSelection.selectByValue("USD");
		Select outputSelection = new Select(driver.findElement(By.id("outputCurrency")));
		outputSelection.selectByValue("EUR");
		WebElement inputBox = driver.findElement(By.id("inputValue"));
		inputBox.sendKeys("1.0");
		
		Thread.sleep(1000);
		WebElement submitButton = driver.findElement(By.id("submitButton"));
		submitButton.click();
		
		Thread.sleep(1000);
		WebElement outputBox = driver.findElement(By.id("outputValue"));
		String textInsideOutputBox = outputBox.getAttribute("value");
		Assertions.assertThat(textInsideOutputBox).isNotNull();
		Assertions.assertThat(textInsideOutputBox).isNotEqualTo("");
		Thread.sleep(1000);

		driver.quit();
	}
}
