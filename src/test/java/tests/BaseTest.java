package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.Constants;

public class BaseTest extends BasePage {

	@BeforeClass
	public void init() {
		initSetp();
		driver.navigate().to("http://demoqa.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void testFindBy() {
		BasePage bp = new BasePage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("entry-title")));
		bp.findObj(Constants.CLASS, "entry-title", true);
		Assert.assertEquals(findObj(Constants.CLASS, "entry-title", true).getText(), "Home");
	}

	@AfterClass
	public void tearDown() {
		tearDownp();
	}
}
