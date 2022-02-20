package functionaljava8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ByLocatorsWithFunctionInterface {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("nav-hamburger-menu")).click();

		// String s = "//div[text()='Echo & Alexa']/parent::a";
		String s1 = "//div[text()='%s']/parent::a";
		String s = String.format(s1, "Echo & Alexa");

		//System.out.println(String.format(s1, "Echo & Alexa"));

		// driver.findElement(By.xpath(String.format(s1, "Echo & Alexa"))).click();
		click(driver, "xpath", String.format(s1, "Echo & Alexa"));

		String n = "//li/a[normalize-space()='%s']";
		// Echo Dot (3rd Gen)
		Thread.sleep(2000);
		click(driver, clickjava8way(driver, "xpath", String.format(n, "Echo Dot (3rd Gen)")));

		Thread.sleep(2000);
		System.out.println("Execution complete");
		driver.close();

	}

	// Clicking an element with older way
	public static void click(WebDriver driver, String locatortype, String value) {
		if (locatortype.equalsIgnoreCase("xpath")) {
			driver.findElement(By.xpath(value)).click();
		} else if (locatortype.equalsIgnoreCase("id")) {
			driver.findElement(By.id(value)).click();
		} else {
			System.out.println("Please pass correct locatortype as 'xpath' or 'id' ");
		}
	}

	// Click an element with Java8 way with functional interface

	public static By clickjava8way(WebDriver driver, String locatortype, String value) {

		Function<String, By> xpath = By::xpath;
		Function<String, By> id = By::id;

		Map<String, Function<String, By>> m = new HashMap<>();

		m.put("xpath", xpath);
		m.put("id", id);

		return m.get(locatortype).apply(value);

	}

	public static void click(WebDriver driver, By by) {
		driver.findElement(by).click();
	}

}
