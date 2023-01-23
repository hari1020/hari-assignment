package com.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment1 {

	static WebDriver driver;

	@BeforeMethod
	public void initializeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hari Prasad\\eclipse-workspace\\InuvestTest\\InuvestAssignment\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://inuvest.tech/");
		driver.manage().window().maximize();
	}

	@Test(priority=1)
	public static void validInputs() {

		try {
			driver.findElement(By.xpath("//a[@class='button login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@name='userEmail'])[1]")).sendKeys("testprofile@inuvest.tech");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("Internshala@123");
			driver.findElement(By.xpath("//button[text()=' Login ']")).click();
			WebElement user = driver.findElement(By.xpath("//a[text()=' Test']"));
			System.out.println(user.getText() + " user logged in Successfully");
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@Test(priority=2)
	public static void invalidInputs() {

		try {
			driver.findElement(By.xpath("//a[@class='button login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@name='userEmail'])[1]")).sendKeys("abcprofile@inuvest.tech");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("Admin123");
			driver.findElement(By.xpath("//button[text()=' Login ']")).click();
			WebElement errorMessage = driver.findElement(By.cssSelector("h2#swal2-title"));
			System.out.println(errorMessage.getText());
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}
	@Test(priority=3)
	public static void assignment2() {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement element1 = wait.until(
					ExpectedConditions.elementToBeClickable
					(By.xpath("//div[@class='lg'] //button[text()=' 6 MONTHS ']")));
			Actions act = new Actions(driver);
			act.moveToElement(element1).perform();
			element1.click();
		} catch (Throwable e) {
			e.printStackTrace();
		}

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
