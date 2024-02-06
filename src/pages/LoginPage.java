package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    String baseUrl = "https://www.saucedemo.com/";
    By usernameInputBy = By.id("user-name");
    By passwordInputBy = By.id("password");
    By loginBtnBy = By.id("login-button");
    By errorElementBy = By.xpath("//h3[@data-test='error']");

    public LoginPage goToLoginPage(){           //UVEK PRVA STRANAAAAA
        driver.get(baseUrl);
        return this;
    }

    public LoginPage login(String username, String password){
        enterText(usernameInputBy, username);
        enterText(passwordInputBy, password);                                       
        clickElement(loginBtnBy);
        return this;
    }

    public LoginPage verifyUnsuccessfulLogin(String expectedError){
        String actualErrorMessage = readText(errorElementBy);
        verifyTextIsTheSame(expectedError, actualErrorMessage);
        return this;
    }

    public LoginPage verifySuccessfulLogout(){
        verifyElementIsVisible(loginBtnBy);
        return this;
    }

}
