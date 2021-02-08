package kontrolni3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SauceDemoTestiranje {

	public static void main(String[] args) {
		/*
		 * Napisati program na programskom jeziku Java koji sluzi za testiranje sajta
		 * https://www.saucedemo.com/ Pokusati logovanje prvo sa nevalidnim, a potom sa
		 * validnim kredencijalima i proveriti da li se nakon toga korisnik nalazi na
		 * odgovarajucoj staranici. Na stranici https://www.saucedemo.com/inventory.html
		 * sortirati proizvode po ceni (od najnize ka najvisoj). Proveriti da li je
		 * sortiranje ispravno. Program pisati postujuci page object model. Koristiti
		 * Test NG za proveru ispravnosti testova. Kredencijale procitati iz datoteke
		 * data.xlsx. Resenje okaciti na GitHub nalog i svoj folder na google drive-u.
		 */
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Marko\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(SaucedemoSite.URL);

		WebElement user1 = driver.findElement(By.xpath(SaucedemoSite.USERNAME_XPATH));

		user1.sendKeys("gaga");
		WebElement password1 = driver.findElement(By.xpath(SaucedemoSite.PASSWORD_XPATH));
		password1.sendKeys("brr");
		driver.findElement(By.xpath(SaucedemoSite.LOGINBUTT_XPATH)).click();
		driver.navigate().refresh();
		
		WebElement user = driver.findElement(By.xpath(SaucedemoSite.USERNAME_XPATH));

		user.sendKeys("standard_user");
		WebElement password = driver.findElement(By.xpath(SaucedemoSite.PASSWORD_XPATH));
		password.sendKeys("secret_sauce");
		driver.findElement(By.xpath(SaucedemoSite.LOGINBUTT_XPATH)).click();
		
		driver.findElement(By.xpath(SaucedemoSite.PRICE_LOWTOHIGH_XPATH)).click();


		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.close();

	}

}
