package week4.day1.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		 * 2. Enter UserName and Password Using Id Locator
		WebElement webUser=driver.findElement(By.id("username"));
		webUser.sendKeys("demosalesmanager");
        driver.findElement(By.id("password")).sendKeys("crmsfa");
		

//		 * 3. Click on Login Button using Class Locator
		driver.findElement(By.className("decorativeSubmit")).click();


//		 * 4. Click on CRM/SFA Link
		driver.findElement(By.linkText("CRM/SFA")).click();


//		 * 5. Click on contacts Button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();

//		 * 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

//	 * 7. Click on Widget of From Contact


//		//Get the number of windows


//	 * 8. Click on First Resulting Contact

//		 * 9. Click on Widget of To Contact




//	 * 10. Click on Second Resulting Contact

//	 * 11. Click on Merge button using Xpath Locator

//	 * 12. Accept the Alert

//		 * 13. Verify the title of the page


		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdFrom']/following-sibling::a").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windowHandlesList = new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowHandlesList.get(1));
		
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]").click();
		Thread.sleep(2000);
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.findElementByXPath("//table[@id='widget_ComboBox_partyIdTo']/following-sibling::a").click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windowHandlesList1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windowHandlesList1.get(1));
		
		driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[2]").click();
		Thread.sleep(2000);
		driver.switchTo().window(windowHandlesList.get(0));
		
		driver.findElementByLinkText("Merge").click();
		
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("View Contact")) {
			System.out.println("Merge successful");
		}
		else
			System.out.println("Merge failed");


	}

	}


