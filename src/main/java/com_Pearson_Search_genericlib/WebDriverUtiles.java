package com_Pearson_Search_genericlib;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com_Pearson_Search_genericlib.IConstant;

/**
 * 
 * @author Shradda
 *
 */
public class WebDriverUtiles {
   /**
    *  used to select the option from the dropdwon based on visible text
    * @param element
    * @param visibleText
    */
	public void select(WebElement element, String visibleText) {
		Select sel = new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	/**
	 * used to select the option from the dropdwon based on position / index (index always start from 0)
	 * @param element
	 * @param index
	 */
	public void select(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
		
	}
	
	/**
	 *  used to wait for Element to be clickable in GUI  & check for the elemnet for every 500 milisecond , 
	 * @param driver
	 * @param elemnet
	 */
	public void waitforElementToBeClickable(WebDriver driver , WebElement element) {
		 WebDriverWait wait = new WebDriverWait(driver, IConstant.explicitlyWaitWiat);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * wait for DOM document to be load before finding any elemnet in GUI
	 * @param driver
	 */
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstant.implicitlyWiat, TimeUnit.SECONDS);
		
	}
	
	/**
	 * used to wait for expected element in GUI
	 * @param element
	 * @throws Throwable
	 */
	public void waitforElement( WebElement element) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   element.isDisplayed();
			     break;
			   }catch (Throwable e) {
				Thread.sleep(500);
				count++;
			   }
	        }
	}
	/**
	 * used to wait for expected element in GUI based on Xpath
	 * @param element
	 * @throws Throwable
	 */
	public void waitAndClick(WebDriver driver , String xpath) throws Throwable {
		  int count = 0;
	        while(count < 40) {
			   try {
				   driver.findElement(By.xpath(xpath)).click();
			     break;
			   }catch (Throwable e) {
				 Thread.sleep(500);
				 count++;
			   }
	        }
	}
	
	/**
	 * SWitch to Required Window based on title Parameter
	 * @param driver
	 * @param partailWindowTitle
	 */
	public void swicthToWindow(WebDriver driver , String partailWindowTitle) {
		  /*get all window session ID*/
		   Set<String> set = driver.getWindowHandles();
		   Iterator<String> it = set.iterator();
		    
		   while(it.hasNext()) {
			   String winID = it.next();
			   driver.switchTo().window(winID);
			   String actTitle = driver.getTitle();
			   if(actTitle.contains(partailWindowTitle)) {
				   System.out.println("swicthed to actual winow");
				   break;
			   }
		   }
	}
	/**
	 * used to Switch to Alert Pop up & click on OK button
	 * @param driver
	 */
	public void alertOK(WebDriver driver) {
		
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to Switch to Alert Pop up & click on cancel button
	 * @param driver
	 */
   public void alertCancel(WebDriver driver) {
		
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to take mouse cursor on expected element on the browser
	 * @param driver
	 * @param element
	 */
	public void moveToExpectedElemnet(WebDriver driver , WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	
/**
 *   wait for element to be available
 * @param driver
 * @param elemnetXpath
 * @throws InterruptedException
 */
	public void waitForElementXpath(WebDriver driver , String elemnetXpath) throws InterruptedException {
		int count =0 ; 
		 while(count<40) {
			 try {
				 driver.findElement(By.xpath(elemnetXpath)).isEnabled();
				 break;
			 }catch (Exception e) {
				Thread.sleep(500);
				count ++;
			}
		 }
	}	
	
	/**
	 * used to perfrom mouse movement action on the elemnet
	 * @param driver
	 * @param elemnet
	 */
	public void moveMouseToElemnet(WebDriver driver , WebElement elemnet) {
		Actions act = new Actions(driver);
		act.moveToElement(elemnet).perform();
	}
	
	/**
	 * used to perform rightClcik action on the element
	 * @param driver
	 * @param elemnet
	 */
	public void rightClick(WebDriver driver , WebElement elemnet) {
		Actions act = new Actions(driver);
		act.contextClick(elemnet).perform();
	}
	/**
	 * 
	 * @param driver
	 */
	public void accpetAllert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * 
	 * @param driver
	 */
	public void cancelAllert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	     
	   
	}
   
	


