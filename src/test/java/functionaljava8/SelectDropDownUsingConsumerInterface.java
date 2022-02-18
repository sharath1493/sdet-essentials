package functionaljava8;

import java.util.function.Consumer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDownUsingConsumerInterface {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		WebElement ele = driver.findElement(By.id("oldSelectMenu"));
		Select s=new Select(ele);

		//Old Style of selecting the Select DropDown
		System.out.println("----------------Old Style Selecting the drop down-----------------------");
		selectDropDownOld(s, "2", "index");
		Thread.sleep(2000);
		selectDropDownOld(s, "0", "index");
		Thread.sleep(2000);
		selectDropDownOld(s, "Purple", "text");
		Thread.sleep(2000);
		selectDropDownOld(s, "red", "value");
		Thread.sleep(2000);
		selectDropDownOld(s, "8", "value");
		Thread.sleep(2000);


		//Select the DropDown with passing consumer interface
		System.out.println("----------------Selecting the drop down with Consumer Interface-----------------------");

		selectDropDownWithConsumerInterface(e -> e.selectByIndex(9), ele);
		Thread.sleep(2000);
		selectDropDownWithConsumerInterface(e -> e.selectByValue("red"), ele);
		Thread.sleep(2000);
		selectDropDownWithConsumerInterface(e -> e.selectByVisibleText("Blue"), ele);
		Thread.sleep(2000);

		driver.close();
	}

	private static void selectDropDownWithConsumerInterface(Consumer<Select> consumer, WebElement ele) {

		consumer.accept(new Select(ele));
	}

	private static void selectDropDownOld(Select select, String textorvalueorindex, String strategy) {

		if(strategy.equalsIgnoreCase("index"))
		{
			select.selectByIndex(Integer.parseInt(textorvalueorindex));
		}
		else if(strategy.equalsIgnoreCase("value"))
		{
			select.selectByValue(textorvalueorindex);
		}
		else if(strategy.equalsIgnoreCase("text"))
		{
			select.selectByVisibleText(textorvalueorindex);
		}
		else
		{
			System.out.println("Please pass the correct strategy from 'index', 'value', 'text'");
		}
	}
}
