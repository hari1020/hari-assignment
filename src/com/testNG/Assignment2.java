package com.testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Assignment2 {

	static WebDriver driver;

	@BeforeClass
	public static void initializeBrowser() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hari Prasad\\eclipse-workspace\\InuvestTest\\InuvestAssignment\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://inuvest.tech/");
		driver.manage().window().maximize();
	}

	//@Test
	public static void signupValid() {

		try {
			driver.findElement(By.xpath("//a//strong[text()='Sign up']")).click();
			driver.findElement(By.name("firstname")).sendKeys("bca");
			driver.findElement(By.name("lastname")).sendKeys("deg");
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("45345987101");
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("admin@india.com");
			driver.findElement(By.name("password")).sendKeys("test@12");
			driver.findElement(By.cssSelector("button[type=submit]")).click();
			WebElement confirmation = driver.findElement(By.xpath("//h2[contains(text(),'Confirmation email')]"));
			System.out.println(confirmation.getText());
			// driver.switchTo().alert().accept(); //
		} catch (Exception e) {

		}
	}

	@Test
	public void signupInvalid() {

		try {
			driver.findElement(By.xpath("//a//strong[text()='Sign up']")).click();
			driver.findElement(By.name("firstname")).sendKeys("abc");
			driver.findElement(By.name("lastname")).sendKeys("test");
			driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("1234567890");
			driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("test123@india.com");
			driver.findElement(By.name("password")).sendKeys("Admin123");
			driver.findElement(By.cssSelector("button[type=submit]")).click();
			WebElement userExist = driver.findElement(By.cssSelector("h2#swal2-title"));
			System.out.println(userExist.getText());
			// driver.switchTo().alert().accept();
		} catch (Exception e) {

		}

	}

	@AfterClass
	public void tearDown() {

		driver.close();
	}

}
