package com.ebanking.master;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Pomexe 
{
	
	WebDriver driver;
     @BeforeTest
	public void Alogin() throws InterruptedException
	{
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://103.211.39.246/ranford2");
		
		//Login
		
		RanfordhHP RHP=PageFactory.initElements(driver,RanfordhHP.class);
		RHP.Login();
		Thread.sleep(3000);
		
		
	}	
     @Test()
     public void Rolecr() throws InterruptedException, IOException
     {
    	 FileInputStream FIS=new FileInputStream("D:\\SepEvngBatch\\Ebanking\\src\\com\\ebanking\\testdata\\Role.xlsx");
    		
	     //WorkBook
		
		XSSFWorkbook WB=new XSSFWorkbook(FIS);
		
		//Sheet
		
		XSSFSheet WS=WB.getSheet("Rdata");
		
		//Row Count
		
		int Rcount=WS.getLastRowNum();
		System.out.println(Rcount);
		
		//Multiple iterations
		
		for (int i=1;i<=Rcount;i++) 
		{
			//Row
			
			XSSFRow WR = WS.getRow(i);
			
			//Cells
			
			XSSFCell WC=WR.getCell(0);
			XSSFCell WC1=WR.getCell(1);
			
			XSSFCell WC2=WR.createCell(2);
			
			//Cell Values
			
			String Rname=WC.getStringCellValue();
			String Rtyp=WC1.getStringCellValue();
	
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
		RC.Rcre(Rname,Rtyp);
		Thread.sleep(3000);
		//Alert
		
		driver.switchTo().alert().accept();
		
		//Home
		
		RD.Rhom();
		
     }
		
     }
     @DataProvider
     public Object [][] Rdata()
     {
           Object[][] Obj=new Object[3][2];
           
           Obj[0][0]="Cashierbnkhyd";
           Obj[0][1]="E";
           
           Obj[1][0]="ManagerbnkHyd";
           Obj[1][1]="E";
           
           Obj[2][0]="Genmanagerbnkhyd";
           Obj[2][1]="E";
           
           return Obj;
           
      }

}