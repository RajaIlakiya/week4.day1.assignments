package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRomm3 {
//	Alerts and Window handling
//	---------------------------
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
//		1. Load https://www.irctc.co.in/
		driver.get("https://www.irctc.co.in/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
//		2. Click on OK button in the dialog  
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		Alert alert = driver.switchTo().alert();
		Thread.sleep(2000);
		alert.accept();
		
//		3. Click on FLIGHTS link            
		driver.findElement(By.xpath("//a[text()=' FLIGHTS ']")).click();
		
//		4. Go to the Flights tab
		Set<String> windowHandleSet= driver.getWindowHandles();
		List<String> windowHandleList=new ArrayList<String>(windowHandleSet);
		windowHandleList.get(1);
		driver.switchTo().window(windowHandleList.get(1));
		System.out.println(driver.getTitle());
		//Get the number of windows
		System.out.println("Number of windows: " + windowHandleList.size());

	
		
//		5. Print the customer care email id
		WebElement email=driver.findElement(By.xpath("(//div[@class='block-nav-right d-none d-md-block'])[2]//a"));
		String text=email.getText();
		System.out.println("Customer care email id: " +text);

//		6. Close the First tab(Train ticket booking) alone
		//get back to main window
		driver.switchTo().window(windowHandleList.get(0));
		System.out.println(driver.getTitle());

		
		
	}

}
