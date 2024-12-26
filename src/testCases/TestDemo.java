package testCases;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestDemo {
	public WebDriver driver;
	
	@Test
	  public void f1()
	  {
		driver=new ChromeDriver();
		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@placeholder=\"Search for anything\"]")).sendKeys("book");
		driver.findElement(By.xpath("//input[@value=\"Search\"]")).click();
		driver.findElement(By.xpath("(//img[@loading=\"eager\"])[3]")).click();
		ArrayList<String> list=new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		WebElement web=driver.findElement(By.xpath("(//a[contains(@href,\"cart.payment\")])[2]"));
		web.click();
		WebElement cart=driver.findElement(By.xpath("//*[@id='gh-cart-n']"));
		String str=cart.getText();
		Assert.assertEquals("1", str);
	  }
	
	@AfterMethod
	  public void afterMethod() {
		    driver.quit();
	  		}

}
