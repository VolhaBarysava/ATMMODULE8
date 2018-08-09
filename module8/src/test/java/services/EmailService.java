package services;

import org.testng.Reporter;

import pages.AccountPage;
import pages.CreateEmailPage;
import pages.HomePage;
import utils.WebDriverSingleton;
import bo.Email;
import bo.User;

public class EmailService {
	public AccountPage loginToMailRu(User user) {
		Reporter.log("Login to Mail", 2, true);
		HomePage homePage = new HomePage (WebDriverSingleton.getWebDriverInstance());
		return homePage.login(user);
// 		since tests shouldn't have access to pages, all service methods can return only values (e.g. boolean, string etc.) or be void.
// 		So these two methods should be made void
// 		all page methods which are now called from tests should be reworked and added to this service class.
	}
	
	public AccountPage sendEmail(Email email) {
		Reporter.log("Send message", 2, true);
		CreateEmailPage createEmailPage = new CreateEmailPage (WebDriverSingleton.getWebDriverInstance());
		return createEmailPage.send(email);
	}
	
	

}
