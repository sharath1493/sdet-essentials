package functionaljava8;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingStateElementwithFunctionInterface {

	@Test
	public void handleStaleElementwithFunctionInterface() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.google.com/");

		WebElement ele = driver.findElement(By.name("q"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		//Removing the element from DOM

		((JavascriptExecutor) driver).executeScript("return document.getElementsByClassName(\"gLFyf gsfi\")[0].remove();");

		//Below Explicit Wait will throw StaleElement Exception

		//wait.until(ExpectedConditions.visibilityOf(ele)).sendKeys("Doctor Strange in M.O.M.");

		//Below Explicit Wait will throw Element Not visible  Exception

		//wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(ele)).sendKeys("Doctor Strange in M.O.M.");

		//handling the StaleElement here with Function Interface

		wait.until(d -> {
			if(!d.findElements(By.name("q")).isEmpty())
			{
				return d.findElements(By.name("q")).get(0);
			}
			else
			{
				d.navigate().refresh();
				return d.findElement(By.name("q"));
			}

		}).sendKeys("Doctor Strange in M.O.M.");

		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

		Thread.sleep(2000);

		driver.close();

	}

}
