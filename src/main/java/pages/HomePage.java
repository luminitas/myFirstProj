package pages;

public class HomePage extends BasePage {
	
	public void accessHomePage() {
		driver.navigate().to("http://demoqa.com/");
		driver.manage().window().maximize();
	}

}
