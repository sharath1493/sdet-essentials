package functionaljava8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OptimizeElementMethodsFunctionInterface {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");

		List<WebElement> ele = driver.findElements(By.xpath("//div[@id='nav-xshop']/a"));

		/*
		 * Requirements 1. Get Text of all elements 2. Get Attribute of all elements 3.
		 * Get tag Name of all elements
		 */

		// Conventional way of getting above requirements - Create specific methods by
		// traversing

		// System.out.println(gettextofelementslist(ele).size());
		// System.out.println(getattributeofelementslist(ele).size());
		// System.out.println(gettagnameofelementslist(ele).size());

		// System.out.println(java8elementoperators(ele, WebElement::getText));
		// System.out.println(java8elementoperators(ele, e -> e.getAttribute("href")));
		// System.out.println(java8elementoperators(ele, WebElement::getTagName));

		// Verifying if both ways are resulting the same result

		System.out.println(gettextofelementslist(ele).equals(java8elementoperators(ele, WebElement::getText)));
		System.out.println(
				getattributeofelementslist(ele).equals(java8elementoperators(ele, e -> e.getAttribute("href"))));
		System.out.println(gettagnameofelementslist(ele).equals(java8elementoperators(ele, WebElement::getTagName)));

		driver.close();

	}

	// Conventional way of getting above requirements - Create specific methods by
	// traversing

	private static List<String> gettagnameofelementslist(List<WebElement> ele) {
		List<String> s = new ArrayList<>();
		for (WebElement e : ele) {

			s.add(e.getTagName());
		}
		return s;
	}

	private static List<String> getattributeofelementslist(List<WebElement> ele) {
		List<String> s = new ArrayList<>();
		for (WebElement e : ele) {

			s.add(e.getAttribute("href"));
		}
		return s;
	}

	private static List<String> gettextofelementslist(List<WebElement> ele) {
		List<String> s = new ArrayList<>();
		for (WebElement e : ele) {

			s.add(e.getText());
		}
		return s;
	}

	// Create java 8 using function interface

	private static List<String> java8elementoperators(List<WebElement> ele, Function<WebElement, String> function) {
		return ele.stream().map(function).toList();

	}

}
