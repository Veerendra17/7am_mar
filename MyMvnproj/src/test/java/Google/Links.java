package Google;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,MethodListener.class})
public class Links 
{

	WebDriver driver;
	
	{
		System.setProperty("atu.reporter.config", "e:/7am_mar_16/myproj/atu.properties");
	}
    public Links(WebDriver driver)
    {
    	System.out.println("hello");
    	this.driver=driver;
    }
	public void getlinks()
	{
		List<WebElement> lst=driver.findElements(By.xpath("//a[starts-with(text(),'selenium') or starts-with(text(),'Selenium')]"));
						
		for(WebElement x : lst)
		{
			ATUReports.add(x.getText(),true);
		}
		
		lst=driver.findElements(By.xpath("//a[contains(text(),'Python')]"));
		for(WebElement x : lst)
		{
			ATUReports.add(x.getText(),true);
		}
	}
}
