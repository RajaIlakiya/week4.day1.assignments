package week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	private static final String frame1 = null;
	private static final String nestedframe1 = null;
	private static final String nestedFrame1 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.findElement(By.xpath("(//div[@id='wrapframe'])[1]//iframe")).click();
driver.switchTo().frame("frame1");
driver.findElement(By.id("Click")).click();
driver.switchTo().defaultContent();


WebElement nestedFrame1=driver.findElement(By.xpath("(//div[@id='wrapframe'])[2]//iframe"));
driver.switchTo().frame(nestedFrame1);
driver.switchTo().frame("frame2");
driver.findElement(By.id("Click1")).click();
driver.switchTo().defaultContent();

WebElement nestedFrame2=driver.findElement(By.xpath("(//div[@id='wrapframe'])[3]//iframe"));
driver.switchTo().frame(nestedFrame2);


	}

}
