package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import bo.Email;
import utils.Highlighter;

public class CreateEmailPage extends BasePage{
	private static final String SEARCH_ACTUAL_MAIL_BODY_LOCATOR = "//*[text()= '%s']";
	
	public CreateEmailPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(css = "textarea[data-original-name = 'To']")
	private WebElement mailToAddress;
	
	@FindBy(name = "Subject")
	private WebElement mailSubject;

	@FindBy(xpath = "//iframe[starts-with(@id,'toolkit')]")
	private WebElement mailBody;
	
	@FindBy(id = "tinymce")
	private WebElement textBody;
	
	@FindBy(xpath = "//*[@id='b-toolbar__right']//*[@data-name='saveDraft']")
	private WebElement saveAsDraftBtn;
	
	@FindBy(xpath = "//*[@id='b-toolbar__right']//*[@data-name='send']")
	private WebElement sendBtn;
	
	@FindBy(xpath = "//*[@id='b-toolbar__right']//*[@data-mnemo='saveStatus']")
	private WebElement saveStatus;
	
	@FindBy(xpath = "//*[@id='compose_to']")
	private WebElement actualMailToAddress;
	
	
	public CreateEmailPage fillMailAddress(String mailAddress){
		waitForElementVisible(mailToAddress);
		Highlighter.highlightElement(mailToAddress);
		mailToAddress.clear();
		mailToAddress.sendKeys(mailAddress);
		Highlighter.unHighlightElement(mailToAddress);
		return new CreateEmailPage(driver);
	}
	
	public CreateEmailPage fillMailSubject(String subject){	
		waitForElementVisible(mailSubject);
		Highlighter.highlightElement(mailSubject);
		mailSubject.clear();
		mailSubject.sendKeys(subject);
		Highlighter.unHighlightElement(mailSubject);
		return new CreateEmailPage(driver);
	}
	
	public CreateEmailPage fillMailBody(String body){
		driver.switchTo().frame(mailBody);
		textBody.clear();
		textBody.sendKeys(body);
		driver.switchTo().defaultContent();	
		return new CreateEmailPage(driver);
	}
	
	public CreateEmailPage clickSaveDraftBtn(){
		Highlighter.highlightElement(saveAsDraftBtn);
		saveAsDraftBtn.click();
		Highlighter.unHighlightElement(saveAsDraftBtn);
		waitForElementVisible(saveStatus);
		Highlighter.highlightElement(saveStatus);
		Highlighter.unHighlightElement(saveStatus);
		return new CreateEmailPage(driver); 
	}

	
	public AccountPage clickMailSendBtn(){
		waitForElementVisible(mailToAddress);
		sendBtn.click();
		return new AccountPage(driver);
	}
	
	public String getMailToAddress(){
		return actualMailToAddress.getAttribute("value");
	}
	
	public boolean isMailBodyEnable(String textBody){
		return driver.findElement(By.xpath(String.format(SEARCH_ACTUAL_MAIL_BODY_LOCATOR, textBody))).isEnabled();
	}
	
	public CreateEmailPage fillMailByJS(String valueAddress){
		new Actions(driver).sendKeys(mailToAddress, valueAddress).build().perform();
		new Actions(driver).sendKeys(mailSubject, "test"+ System.nanoTime()).build().perform();
		
		driver.switchTo().frame(mailBody);
		new Actions(driver).sendKeys(textBody, "to test actions").build().perform();
		driver.switchTo().defaultContent();		
		return new CreateEmailPage(driver);
	}

	public AccountPage send(Email email) {
// 		It's better to give a meaningful name to the method: sendEmail or clickSendEnailButton
		waitForElementVisible(mailToAddress);
		sendBtn.click();
		return new AccountPage(driver);
	}
	
}
