package Google;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.logging.LogAs;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class})
public class Home 
{
	WebDriver driver;
	{
		System.setProperty("atu.reporter.config", "e:/7am_mar_16/myproj/atu.properties");
	}
    public Home(WebDriver driver)
    {
    	this.driver=driver;
    }
	public void open()
	{
		System.out.println("opening website");
		driver.manage().window().maximize();
		driver.get("http://www.google.com");		
	}
	public void search() throws Exception
	{
		driver.findElement(By.id("lst-ib")).sendKeys("selenium");
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
		//driver.findElement(By.xpath("//input[starts-with(@name,'btnG') or starts-with(@name,'btnK')]")).click();	
		Thread.sleep(5000);
		try
		{
			if(driver.findElement(By.id("resultStats")).isDisplayed())
			{
				String res=driver.findElement(By.id("resultStats")).getText();
				ATUReports.add(res,LogAs.PASSED,new CaptureScreen(ScreenshotOf.DESKTOP));			
			}
		}
		catch(Exception e)
		{
			ATUReports.add("Results not displayed",LogAs.FAILED,new CaptureScreen(ScreenshotOf.DESKTOP));
		}
		
	
	}
}
