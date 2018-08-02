package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.Constants;

public class BasePage {

	public static WebDriver driver;
	public static WebDriverWait wait;

	public void initSetp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 15);
	

	}

	public WebElement findObj(String typeElem, String valueElem, boolean mandatory) {

		WebElement elem = null;
		By locator = null;
		if (typeElem.equals(Constants.ID)) {
			locator = By.id(valueElem);
		} else if (typeElem.equals(Constants.CLASS)) {
			locator = By.className(valueElem);
		} else if (typeElem.equals(Constants.CSS)) {
			locator = By.cssSelector(valueElem);
		} else if (typeElem.equals(Constants.LINK)) {
			locator = By.linkText(valueElem);
		} else if (typeElem.equals(Constants.XPATH)) {
			locator = By.xpath(valueElem);
		}
		try {
			elem = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("");
		}
		if (mandatory == true && elem == null) {
			System.out.println("Big problem");
		}
		return elem;

	}

	public void clickObj(String typeElem, String valueElem, boolean mandatory) {
		WebElement elm = null;
		try {
			elm = findObj(typeElem, valueElem, mandatory);
			if (elm.isDisplayed()) {
				elm.click();
			}
		} catch (Exception e) {
			System.out.println("The element is not displayed");
		}
	}

	public void tearDownp() {
		driver.close();
		if (driver != null) {
			driver.quit();
		}
	}

}
