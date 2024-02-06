package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver){
        super(driver);
    }
    By firstNameBy = By.xpath("//*[@id=\"first-name\"]");
    By lastNameBy = By.xpath("//*[@id=\"last-name\"]");                  
    By zipCodeBy = By.xpath("//*[@id=\"postal-code\"]");
    By continueButton = By.xpath("//*[@id=\"continue\"]");
    By cancelButton = By.xpath("//*[@id=\"cancel\"]");
    By finishOrderButton = By.xpath("//*[@id=\"finish\"]");
    By backToHomeButton = By.xpath("//*[@id=\"back-to-products\"]");
    By pageTitleBy = By.xpath("//span[@class='title']");
    
//click na firstName element, i send keys sa enter text metodom
//click na lastName element, i send keys sa enter text metodom
//click na zipCode element, i send keys sa enter text metodom




    
    public CheckoutPage inputCredentialsCheckout(String firstName, String lastName, String zipcodeNum){
        enterText(firstNameBy, firstName);
        enterText(lastNameBy, lastName);                 
        enterText(zipCodeBy, zipcodeNum);
        return this;
}
    public CheckoutPage navToCheckoutPage2(){
        clickElement(continueButton);
        return this;
    }
    public CheckoutPage finishOrder(){
        clickElement(finishOrderButton);
        return this;
    }
    public CheckoutPage backToHomeNav(){
        clickElement(backToHomeButton);
        return this;
    }
    public CheckoutPage verifyCompletedOrder(String expectedPageTitle){
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }

    }

