package org.demo.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

	@Test
	public void testApp() {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.
		String browser = "firefox";
		WebDriver driver = WebDriverFactory.getInstance().getWebDriver(browser);

		// And now use this to visit Google
		driver.get("https://www.google.com");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));

		// Enter something to search for
		element.sendKeys("Cheese!");

		// Now submit the form. WebDriver will find the form for us from the element
		element.submit();

		// Check the title of the page
		System.out.println("Page title is: " + driver.getTitle());

		// Google's search is rendered dynamically with JavaScript.
		// Wait for the page to load, timeout after 10 seconds
		(new WebDriverWait(driver, 10))
			.until((ExpectedCondition<Boolean>) webDriver -> webDriver.getTitle().toLowerCase().startsWith("cheese!"));

		// Should see: "cheese! - Google Search"
		System.out.println("Page title is: " + driver.getTitle());

		// Close the browser
		driver.quit();

		Assert.assertTrue(true);
	}
}
