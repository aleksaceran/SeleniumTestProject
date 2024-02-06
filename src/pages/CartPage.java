package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver){
        super(driver);
    }
    By pageTitleBy = By.xpath("//span[@class='title']");
    By itemNamesBy = By.xpath("//div[@class='inventory_item_name']");
    By continueShopping = By.xpath("//*[@id=\"continue-shopping\"]");
    By removeItemFromCart = By.xpath("//*[@id='remove-sauce-labs-backpack']");
    By checkoutButton = By.xpath("//*[@id=\"checkout\"]");

    By cartItemVisible = By.xpath("//div[@class='cart_item']");
    By cartItemRemoved = By.xpath("//div[@class='removed_cart_item']");
    int expectedProductCount = 1;

    String CheckoutPageTitle1 = "Checkout: Your Information";
    String CheckoutPageTitle2 = "Checkout: Overview";
    String CheckoutPageTitle3 = "Checkout: Complete!";
    

    public CartPage verifyCartNavigation(String expectedPageTitle){
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }
    public CartPage verifyThatCertainItemIsInCart (String expectedItemName){
        String actualItemName = readText(itemNamesBy);
        verifyTextIsTheSame(expectedItemName, actualItemName);
        return this;
    }

    public CartPage verifyReturnToPLP(){
        clickElement(continueShopping);
        return this;

    }
    public CartPage verifyReturnToPDP(){
        clickElement(itemNamesBy);
        return this;

    }
    public CartPage removeItemFromCart(){
        clickElement(removeItemFromCart);

        return this;
    }
    
    
    
    public CartPage goToCheckoutPage(){
        clickElement(checkoutButton);
        return this;
    }
    public CartPage verifyCheckoutPage(String expectedPageTitle){
        String actualPageTitle = readText(pageTitleBy);                                
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;


    }

}