package org.demo.selenium;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverFactory {

	private static final String PROXY = "localhost:1984";

	private static WebDriverFactory factory;

	private WebDriverFactory() {
		factory = this;
	}

	public static WebDriverFactory getInstance() {
		if (factory == null) {
			factory = new WebDriverFactory();
		}

		return factory;
	}

	public WebDriver getWebDriver(String browser) {
		WebDriver driver = null;

		switch (browser) {
			case "firefox":
				driver = getFirefoxDriver();
				break;
			default:
				break;
		}

		return driver;
	}

	private WebDriver getFirefoxDriver() {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();

		// use legacy firefox
//		System.setProperty("webdriver.firefox.marionette", "false");
		capabilities.setCapability("marionette", false);

		// proxy
		Proxy proxy = new Proxy();
		proxy.setHttpProxy(PROXY)
			.setSslProxy(PROXY);
		capabilities.setCapability(CapabilityType.PROXY, proxy);

		WebDriver driver = new FirefoxDriver(capabilities);
		return driver;
	}
}
