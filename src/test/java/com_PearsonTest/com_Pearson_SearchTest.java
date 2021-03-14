package com_PearsonTest;


	import java.io.FileWriter;
	import java.util.ArrayList;
	import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebElement;
	import org.testng.Assert;
	import org.testng.annotations.Test;

	import com.opencsv.CSVWriter;

	import com_Pearson_Search_genericlib.BaseClass;
	import com_Pearson_ObjectRepository.HomePage;

	public class com_Pearson_SearchTest extends BaseClass
		{
			@Test (priority=1)	
			public void searchtestcase() throws Throwable
			{
			HomePage hp=new HomePage(driver);
			    
				hp.getSearchBOX().sendKeys("Computer Science",Keys.ENTER);
				Thread.sleep(2000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			     js.executeScript("window.scrollBy(0,350)", "");
				WebElement searchResult = hp.getContentVal();
				Thread.sleep(2000);
				List<WebElement> Prodlist = hp.getProdTitle();
				List<WebElement> prAuthor = hp.getProdAuthor();
				String[] headr = {"Title", "Author"};
				List<String[]> list = new ArrayList<String[]>();
				list.add(0,headr);
				System.out.println("First 10 search of first page");
				for(int i=0;i<10;i++)
				{
					String plist=Prodlist.get(i).getText();
					String pauthor=prAuthor.get(i).getText();
					System.out.println("----product-----"+i);
					
					System.out.println(plist);
					System.out.println(pauthor);
					String[] row1 = {Prodlist.get(i).getText(), prAuthor.get(i).getText()};
					list.add(i, row1);
				}
				CSVWriter writecsv = new CSVWriter(new FileWriter("./TestOutputs/ProdDeatils.csv"));
				writecsv.writeAll(list);
				writecsv.close();
			}

			@Test (priority=2)	
			public void searchnexttestcase() throws Throwable
			{
				HomePage hp=new HomePage(driver);
			 hp.getSearchBOX().sendKeys("Computer Science",Keys.ENTER);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			     js.executeScript("window.scrollBy(0,650)", "");
				WebElement searchResult = hp.getContentVal();
				Thread.sleep(2000);
				List<WebElement> Prodlist = hp.getProdTitle();
				List<WebElement> prAuthor = hp.getProdAuthor();
				WebElement nxt=hp.getNextPge1();
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click()", nxt);
				
				String[] headr = {"Title", "Author"};
				List<String[]> list = new ArrayList<String[]>();
				list.add(0,headr);
				System.out.println("First 10 search of Second page");
				for(int i=0;i<10;i++)
				{
					String plist=Prodlist.get(i).getText();
					String pauthor=prAuthor.get(i).getText();
					System.out.println("----product-----"+i);
				
					System.out.println(plist);
					System.out.println(pauthor);

	}
			
			}
			@Test (priority=3)	
			public void searchThirdprodtestcase() throws Throwable
			{
				HomePage hp=new HomePage(driver);
			 hp.getSearchBOX().sendKeys("Computer Science",Keys.ENTER);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			     js.executeScript("window.scrollBy(0,650)", "");
				WebElement searchResult = hp.getContentVal();
				Thread.sleep(2000);
				List<WebElement> Prodlist = hp.getProdTitle();
				List<WebElement> prAuthor = hp.getProdAuthor();
				String[] headr = {"Title", "Author"};
				List<String[]> list = new ArrayList<String[]>();
				list.add(0,headr);
				for(int i=0;i<10;i++)
				{
					if(i==3) 
					{
						Prodlist.get(i).click();
						Thread.sleep(2000);
						//((WebElement) Prodlist).click();
					}

	}
			}
		}
			
			
			
			
			
		
				

		
				
				
			


