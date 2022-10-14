package com.AgileCrmAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

	public static void main(String[] args) {

			System.setProperty("webdriver.chrome.driver", "C:\\Chrome_Driver\\chromedriver_win32 (1)\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.get("https://testingqa.agilecrm.com/login");
			driver.manage().window().maximize();
			WebElement email=driver.findElement(By.cssSelector("input[placeholder='User ID (Your Email Address)']"));
			email.sendKeys("pandurang@yopmail.com");
			WebElement pass=driver.findElement(By.cssSelector("input[placeholder='Password']"));
			pass.sendKeys("Test1234");
			WebElement Submit=driver.findElement(By.xpath("//input[@type='submit']"));
			Submit.click();
			WebElement contact=driver.findElement(By.xpath("// li[@id='contactsmenu']"));
			contact.click();
	}

	public void login(String email, String pass) {
		// TODO Auto-generated method stub
		
	}

}
