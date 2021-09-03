package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClassRoom2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
driver.findElement(By.id("home")).click();
Set<String> windowHandleSet= driver.getWindowHandles();
List<String> windowHandleList=new ArrayList<String>(windowHandleSet);
driver.switchTo().window(windowHandleList.get(1));
System.out.println(driver.getTitle());

//Get the number of windows
System.out.println("Number of windows: " + windowHandleList.size());

//get back to main window
driver.switchTo().window(windowHandleList.get(0));
System.out.println(driver.getTitle());


}

}
