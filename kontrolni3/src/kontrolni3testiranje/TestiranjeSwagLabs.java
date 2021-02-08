package kontrolni3testiranje;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.log4testng.Logger;

import kontrolni3.SaucedemoSite;

public class TestiranjeSwagLabs {

 WebDriver driver;
	
	@BeforeClass
	public void createDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marko\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test
	public void testValidniLogin() {
		driver.get(SaucedemoSite.URL);
		WebElement user = driver.findElement(By.xpath(SaucedemoSite.USERNAME_XPATH));

		user.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath(SaucedemoSite.PASSWORD_XPATH));
		password.sendKeys("secret_sauce");
		driver.findElement(By.xpath(SaucedemoSite.LOGINBUTT_XPATH)).click();
		
		String actual =  driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected);
	}
	@Test
	public void testNevalidniLogin() {
		driver.get(SaucedemoSite.URL);
		WebElement user = driver.findElement(By.xpath(SaucedemoSite.USERNAME_XPATH));

		user.sendKeys("gaga");
		WebElement password = driver.findElement(By.xpath(SaucedemoSite.PASSWORD_XPATH));
		password.sendKeys("gaga");
		driver.findElement(By.xpath(SaucedemoSite.LOGINBUTT_XPATH)).click();
		
		String actual =  driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/";
		Assert.assertEquals(actual, expected);
		
	}
	@Test
	public void testPrice() {
		WebElement user = driver.findElement(By.xpath(SaucedemoSite.USERNAME_XPATH));

		user.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath(SaucedemoSite.PASSWORD_XPATH));
		password.sendKeys("secret_sauce");
		driver.findElement(By.xpath(SaucedemoSite.LOGINBUTT_XPATH)).click();
		
		driver.findElement(By.xpath(SaucedemoSite.PRICE_LOWTOHIGH_XPATH)).click();
		String actual =  driver.getCurrentUrl();
		String expected = "https://www.saucedemo.com/inventory.html";
		Assert.assertEquals(actual, expected);	
		
	}
	public void SortiranjePrice() {
		driver.get(SaucedemoSite.PRICE_LOWTOHIGH_XPATH);
		
		WebElement element = driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/select/option[3]"));
								
		Select se = new Select(element);
		List<String> originalList = new ArrayList();
		for (WebElement e : se.getOptions()) {
			originalList.add(e.getText());
		}

		List<String> tempList= originalList;
		Collections.sort(tempList);
		Assert.assertEquals(tempList, originalList);
		driver.close();
	}
}
