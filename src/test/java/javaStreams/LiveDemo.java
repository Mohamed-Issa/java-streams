package javaStreams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.xpath("//tr//th[1]")).click();

		List<WebElement> elements = driver.findElements(By.xpath("//tr//td[1]"));

		List<String> originalsNames = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sortedList = originalsNames.stream().sorted().collect(Collectors.toList());

		sortedList.stream().forEach(s -> System.out.println(s));

		Assert.assertEquals(originalsNames, sortedList);

		List<String> price;

		do {

			List<WebElement> rows = driver.findElements(By.xpath("//tr//td[1]"));
			price = rows.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("[aria-label='Next']")).click();
			}

			price.forEach(e -> System.out.println(e));
		} while (price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return price;
	}

}
