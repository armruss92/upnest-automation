package com.upnest.framework.helper.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.upnest.framework.helper.BasePageObject.PageBase;
import com.upnest.framework.helper.Button.ButtonHelper;
import com.upnest.framework.helper.DropDown.DropDownHelper;
import com.upnest.framework.helper.Logger.LoggerHelper;
import com.upnest.framework.helper.Navigation.NavigationHelper;
import com.upnest.framework.helper.TextBox.TextBoxHelper;
import com.upnest.framework.settings.ObjectRepo;

public class HomePage extends PageBase {
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	/** Web Elements */
	@FindBy(how=How.ID,using="buysellHeroFormLocation")
	public WebElement compare_agent_txtbox;
	
	@FindBy(how=How.XPATH,using="//input[@type='submit'][@value='Compare Agents']")
	public WebElement compare_agent_btn;
		
	
	/** Default Methods **/
	
	/** Public Methods  **/
	
	public WebDriver getDriver() {
		return this.driver;
	}
	
	public String getHomePageTitle(){
		return new NavigationHelper(driver).getTitle();
	}
	
	public void search_agent(String searchAgentStr) {		
		compare_agent_txtbox.clear();
		compare_agent_txtbox.sendKeys(searchAgentStr);
		log.info(searchAgentStr);
	}
	
	public void clickCompareButton(){
		new ButtonHelper(driver).click(compare_agent_btn);
	}
}
