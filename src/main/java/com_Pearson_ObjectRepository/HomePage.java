package com_Pearson_ObjectRepository;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import  com_Pearson_Search_genericlib.WebDriverUtiles;
	/**
	 * 
	 * @author shradda
	 *
	 */


	public class HomePage extends com_Pearson_Search_genericlib.WebDriverUtiles{
		WebDriver driver;
		public HomePage(WebDriver driver) {     
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(id="search-box-input")
		private WebElement searchBOX;
		
		
		@FindBy(xpath="//p[@class=\'search-results-header__text js-search-results-text\']")
		private WebElement ContentVal;
		
		@FindBy(xpath="//a[@class='product-card__title-link']")
		private List<WebElement> ProdTitle;
		@FindBy(xpath="//a[@rel='next']")
		private WebElement Next;
		

		

		public WebElement getSearchBOX() {
			return searchBOX;
		}

		public WebElement getContentVal() {
			return ContentVal;
		}

		public List<WebElement> getProdTitle() {
			return  ProdTitle;
		}

		public List<WebElement> getProdAuthor() {
		return ProdAuthor;
		}

		

		@FindBy(xpath="//p[@class='product-card__author']")
		private List<WebElement> ProdAuthor;
	

		

		public WebElement getNextPge1() {
			
			return Next;
		}

		
		
		
		
		
		}


