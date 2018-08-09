package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import utils.Highlighter;
import bo.User;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver) {
		super(driver);
}
	
	@FindBy(id = "mailbox:login")
	private WebElement loginField;

	@FindBy(id = "mailbox:password")
	private WebElement passwordField;
	
	@FindBy(id = "mailbox:submit")
	private WebElement submitBtn;
	
	public AccountPage login(User user){
		waitForElementVisible(loginField);
		Highlighter.highlightElement(loginField);
		loginField.clear();
		loginField.sendKeys(user.getLogin());
		Highlighter.unHighlightElement(loginField);
		
		waitForElementVisible(passwordField);
		Highlighter.highlightElement(passwordField);
		passwordField.clear();
		passwordField.sendKeys(user.getPassword());
		Highlighter.unHighlightElement(passwordField);
		
		waitForElementVisible(submitBtn);
		Highlighter.highlightElement(submitBtn);
		Highlighter.unHighlightElement(submitBtn);
		submitBtn.click();
		
		new Actions(driver).click(submitBtn).build().perform();
		return new AccountPage(driver);
	}
// 	Let's split thid method into 3 page methods. What we have now is a good example of service method.
// 	1. fillUsername
// 	2. fillPassword
// 	3. clickLogInButton
// 	All these 3 methods will be conmined into one "logIn" in service
		
	
}
