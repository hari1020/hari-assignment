package Assignment.com;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTestCase {
	static WebDriver driver;	//global declaration
	
	public static void initializeBrowser(){
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Hari Prasad\\eclipse-workspace\\InuvestTest\\InuvestAssignment\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://inuvest.tech/");
		driver.manage().window().maximize();
		//System.out.println(driver.getTitle());
		
	}
	
	public static void validInputs(){
		
			try {
				driver.findElement(By.xpath("//a[@class='button login']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@name='userEmail'])[1]")).sendKeys("testprofile@inuvest.tech");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("Internshala@123");
				driver.findElement(By.xpath("//button[text()=' Login ']")).click();
				WebElement user = driver.findElement(By.xpath("//a[text()=' Test']"));
				System.out.println(user.getText()+" user logged in Successfully");
			} catch (Exception e) {
				
			}
			driver.close();
	}
	
	public static void invalidInputs(){
		
		try {
			driver.findElement(By.xpath("//a[@class='button login']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("(//input[@name='userEmail'])[1]")).sendKeys("abcprofile@inuvest.tech");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@name='userPassword']")).sendKeys("Admin123");
			driver.findElement(By.xpath("//button[text()=' Login ']")).click();
			WebElement errorMessage = driver.findElement(By.cssSelector("h2#swal2-title"));
			System.out.println(errorMessage.getText());
		} catch (Exception  e) {
		}
		driver.close();
		
}
	public static void assignment2() {
		
		
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable
					(By.xpath("//div[@class='sm']//button[text()=' 6 MONTHS ']")));
			Actions act = new Actions(driver);
			act.moveToElement(element1).perform();
			element1.click();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		initializeBrowser();
		//validInputs();
		//invalidInputs();
		assignment2();
	

	}

}
