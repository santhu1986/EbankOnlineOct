package com.ebanking.master;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Grid 
{

	DesiredCapabilities Cap;
	@Parameters("Browser")
	@Test
	public void Gd(String Br) throws MalformedURLException, InterruptedException
	{
		if (Br.equalsIgnoreCase("firefox")) 
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("firefox");
			Cap.setPlatform(Platform.WINDOWS);
				
		}
		else if (Br.equalsIgnoreCase("chrome"))
		{
			Cap=new DesiredCapabilities();
			Cap.setBrowserName("chrome");
			Cap.setPlatform(Platform.WINDOWS);
				
		}
		
		RemoteWebDriver driver=new RemoteWebDriver(new URL("http://192.168.41.1:4444/wd/hub"),Cap);

		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		//Login
		
		RanfordhHP RHP=PageFactory.initElements(driver,RanfordhHP.class);
		RHP.Login();
		Thread.sleep(3000);
		
		//Role
		
				AdminHP AHP=PageFactory.initElements(driver,AdminHP.class);
				AHP.Rol();
				
				Thread.sleep(3000);
				//New Role
				
				RoleDetails RD=PageFactory.initElements(driver,RoleDetails.class);
				RD.Newrole();
				Thread.sleep(3000);
				//Role Creation
				
				Rolecreation RC=PageFactory.initElements(driver,Rolecreation.class);
				RC.Rcre("Clerkbvg","E");
				Thread.sleep(3000);
				//Alert
				
				driver.switchTo().alert().accept();
				
		}
	
}
