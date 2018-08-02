package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Constants;
import pages.HomePage;

public class HomePageTest extends BaseTest {
	
	@Test
	public void testHomePage() {
		HomePage hp = new HomePage();
		hp.accessHomePage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("dropdown-toggle")));
		hp.clickObj(Constants.CLASS, "dropdown-toggle", true);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='menu-item-66']/a")));
		hp.clickObj(Constants.XPATH, ".//*[@id='menu-item-66']/a", true);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ui-id-3"))).click();
		Assert.assertEquals(findObj(Constants.ID, "tabs-3", true).getText(), "Content 3 Title\n" + 
				"The content could contain anything text page or submit form or any other HTML objects.", "Eroare");
	}

}
