package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{
    public ProductDetailsPage(WebDriver driver){
        super(driver);
    }

    By navigateToPLP = By.xpath("//*[@id=\"back-to-products\"]");
    By addBackPackToCartFrom = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");
    By cartIconBy = By.xpath("//a[@class='shopping_cart_link']");
    By pageTitleBy = By.xpath("//span[@class='title']");

    public ProductDetailsPage verifyNavigateToPLP(String expectedPageTitle){
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }
    
    

    public ProductDetailsPage navigateToPLP(){
        clickElement(navigateToPLP);
        return this;
}
    public ProductDetailsPage addToCartFunction(){
    clickElement(addBackPackToCartFrom);

    return this;
    }
    public ProductDetailsPage navigateToCartPage(){
        clickElement(cartIconBy);
        return this;


}
}