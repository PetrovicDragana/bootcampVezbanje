package kontrolni3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SaucedemoSite {

	public static final String URL = "https://www.saucedemo.com/";
	public static final String USERNAME_XPATH = "//*[@id=\"user-name\"]";
	public static final String PASSWORD_XPATH = "//*[@id=\"password\"]";
	public static final String LOGINBUTT_XPATH = "//*[@id=\"login-button\"]";
	public static final String MENU_XPATH = "//*[@id=\\\"inventory_filter_container\\\"]/select";
	public static final String PRICEURL = "https://www.saucedemo.com/inventory.html";
	public static final String PRICE_LOWTOHIGH_XPATH = "//*[@id=\"inventory_filter_container\"]/select/option[3]";
	public static void ButtonClick(WebDriver driver) {
		driver.findElement(By.xpath("//*[@id=\\\"login-button\\\"]\"")).click();
	}
public static void inputUserName(WebDriver driver,String username) {
	WebElement user1 = driver.findElement(By.xpath(SaucedemoSite.USERNAME_XPATH));

	user1.sendKeys(username);
	
}
public static void inputPassword(WebDriver driver,String password) {
	WebElement password1 = driver.findElement(By.xpath(SaucedemoSite.PASSWORD_XPATH));

	password1.sendKeys(password);
	
	}
}

