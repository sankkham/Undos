package com.test;


import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Undos {

	
	public static void main(String[] args) throws InterruptedException {
		
		// Setup and instantiate Browser
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\acer\\eclipse-workspace\\com.test\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		// Open link on browser
		driver.get("https://prueba.undostres.com.mx/");
		
		//Number given under Numero de celular field
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"col-sm-12\"]/form/div/div[1]/div[1]/div[2]/ul/li[1]/div/div/input"));
		phone.sendKeys("8465433546");
		
		Thread.sleep(1000);

		//Given network under recarga celular
		FluentWait<WebDriver> fluent = new FluentWait<WebDriver>(driver)
			       .withTimeout(Duration.ofSeconds(30))
			       .pollingEvery(Duration.ofSeconds(6))
			       .withMessage("Rukja oh dil diwane..")
			       .ignoring(NoSuchElementException.class);
		
		fluent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[2]/ul/li[2]/div/div/input"))).click();
		fluent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[2]/ul/li[2]/div/div/div/ul/li[1]"))).click();
		Thread.sleep(1000);
		//Selected recharge under Monto de Recarga
		fluent.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[2]/ul/li[3]/div/div/div/ul[1]/li[1]"))).click();
		Thread.sleep(1000);
		//Recharge Done
		WebElement siguiente = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/div/div[1]/form/div/div[1]/div[1]/div[3]/div/button"));
		siguiente.click();
		Thread.sleep(1000);
		
		//Payment Details
		WebElement Tarjeta = driver.findElement(By.id("cardGly"));
		Tarjeta.click();
	
		WebElement hover = driver.findElement(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[1]"));
		Actions act = new Actions(driver);
		act.moveToElement(hover).perform();
		
		WebDriverWait explicit = new WebDriverWait(driver, Duration.ofSeconds(5));
		explicit.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[1]"))).click();		
		Thread.sleep(1000);
		
		WebElement Cardnumber = driver.findElement(By.id("cardnumberunique"));
		Cardnumber.sendKeys("4111111111111111");
		
		WebElement month = driver.findElement(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[2]/td/div/div/div[2]/form/div[3]/div[1]/div/div[1]/input"));
		month.sendKeys("11");
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement year;
		year = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[2]/td/div/div/div[2]/form/div[3]/div[1]/div/div[3]/input")));
		year.sendKeys("25");
		
		WebElement cvv = driver.findElement(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[2]/td/div/div/div[2]/form/div[3]/div[2]/div/input"));
		cvv.sendKeys("111");		
		Thread.sleep(1000);
		
		WebElement mail = driver.findElement(By.xpath("/html/body/div[34]/div[1]/div[3]/div/div[1]/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/table/tbody/tr[2]/td/div/div/div[2]/form/div[4]/div/div/input"));
		mail.sendKeys("test@test.com");		
		Thread.sleep(1000);
		
		WebElement recharge = driver.findElement(By.id("paylimit"));
		recharge.click();		
		Thread.sleep(1000);
	
		// Login & CAPTCHA
	        	WebElement username = driver.findElement(By.id("usrname"));
	    		WebElement password = driver.findElement(By.id("psw"));
	    		username.sendKeys("automationexcersise@test.com");
	    		password.sendKeys("123456");
	    		
	
	    		//var wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='reCAPTCHA']")));
				var captchaCheckbox = wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//div[@class='recaptcha-checkbox-border']"))));
				captchaCheckbox.click();
				 
				
				driver.switchTo().defaultContent(); 
				var submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));
				submitButton.click();
				 
	
		driver.quit();
	}

}
