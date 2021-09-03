package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(1000);
		alert.accept();
		
		
		WebElement result=driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		result.click();
		alert.dismiss();

		if(result.isDisplayed())
		{
			String text=alert.getText();
if(text.contains("You pressed OK!"))
{
		System.out.println("You pressed OK!");
		}
else
{
	System.out.println("You pressed Cancel!");

		}
		}
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		alert.sendKeys("Test Leaf");
		alert.accept();
		
	}

}
