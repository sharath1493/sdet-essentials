package functionaljava8;

import java.util.List;

import org.checkerframework.checker.interning.qual.FindDistinct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinksOnAmazon {

	public static void main(String[] args) {

		/*
		 * Assignment :
				Open Amazon.in
				Fetch all the links in the amazon.in home page.
				Fetch the text from the links and remove the empty links
				Remove the duplicates.
				Sort the text in the alphabetical order.
				Print only the text starting with character āCā and āDā
		 */

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--force-dark-mode");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(capabilities);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.get("https://www.amazon.in/");
		List<WebElement> links = driver.findElements(By.tagName("a"));

		links.stream()
		.map(e -> e.getText())
		.filter(s -> !s.isBlank())
		.distinct()
		.sorted()
		.filter(s-> s.startsWith("C") || s.startsWith("F"))
		.forEach(s-> System.out.println(s));

		driver.close();
	}

}
