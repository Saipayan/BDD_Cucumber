package Stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginStepDefinition {

	public static WebDriver driver;
	
	
	@Before
	public void set_up()
	{
		System.out.println("Hello");
	}
	
	
	@After
	public void tear_down()
	{
		System.out.println("tearing down");
	}
	
	
	@Given("^user navigates to Expedia website$")
	public void user_Already_in_loginPAGE()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://freecrm.co.in/");
		
	}
	
	
	@When("^user verifies the homepage title$")
	public void Title_OF_CRM_Matching()
	{
		String Title=driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Free CRM #1 cloud software for any business large or small");
	}
	
	@Then("^user click on logIn button$")
	public void user_clicks_on_logIN()
	{
		/*
		 * WebElement loginBTN = driver.findElement(By.)); JavascriptExecutor js =
		 * (JavascriptExecutor)driver; js.executeScript("arguments[0].click;",
		 * loginBTN);
		 */
		
		driver.get("https://ui.freecrm.com/");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Then("^user enter the username and password$")
	public void user_enters_username_and_password(DataTable credentials)
	{
		for (Map<String, String> data : credentials.asMaps(String.class, String.class)) {

			driver.findElement(By.name("email")).sendKeys(data.get("username"));
			driver.findElement(By.name("password")).sendKeys(data.get("password"));
		}
	}
	@Then("^user click on button in LogIN page$")
	public void user_clicks_on_button_logINPAGE()
	{
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	@Then("^the user should be successfully logged in$")
	public void the_user_should_be_successfully_logged_in()  {
	    
	    String Title = driver.getTitle();
	    Assert.assertEquals("Cogmento CRM", Title);
	}


	
	
	
	
	
	
	
	
	
	
}
