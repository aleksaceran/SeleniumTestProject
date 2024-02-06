package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsListPage extends BasePage{
    public ProductsListPage(WebDriver driver){
        super(driver);
    }

    String expectedPageTitle = "Products";
    By pageTitleBy = By.xpath("//span[@class='title']");
    By hamburgerMenuBtnBy = By.id("react-burger-menu-btn");
    By logoutLinkBy = By.id("logout_sidebar_link");
    By cartIconBy = By.xpath("//a[@class='shopping_cart_link']");
    By sortDropdownBy = By.xpath("//select[@class='product_sort_container']");
    By itemNamesBy = By.xpath("//div[@class='inventory_item_name ']");
    By productSelector = By.cssSelector(".inventory_item");
    int expectedProductCount = 6;
    By addBackPackToCartFrom = By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]");

    public ProductsListPage verifySuccessfulLogin(){
        String actualPageTitle = readText(pageTitleBy);
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }

    public ProductsListPage expandMenu(){
        clickElement(hamburgerMenuBtnBy);
        return this;
    }
    public ProductsListPage logout(){
        clickElement(logoutLinkBy);
        return this;
    }
    public ProductsListPage navigateToCartPage(){
        clickElement(cartIconBy);
        return this;
    }
    public ProductsListPage sortProducts(String sortValue){
        selectOptionByValue(sortDropdownBy, sortValue);
        return this;
    }
    public ProductsListPage verifyFirstItemName(String expectedProductName){
        String actualProductTitle = readText(itemNamesBy);
        verifyTextIsTheSame(expectedProductName, actualProductTitle);
    return this;
}

    public ProductsListPage countProducts(){
        java.util.List<WebElement> productList = driver.findElements(productSelector);
        int actualProductCount = productList.size();
        verifyNumberOfElements(expectedProductCount, actualProductCount);
        return this;
    }
    public ProductsListPage navigateToPDP(){
        clickElement(itemNamesBy);
        return this;
    }
    public ProductsListPage addToCartFunction(){
        clickElement(addBackPackToCartFrom);

        return this;
    }
    
    public ProductsListPage verifyNavigateToPLP(String expectedPageTitle){              // OVO PRAKTICNO RADI ISTO STO I VERIFY SUCCESSFUL LOGIN KOJI NAM DAJE INFORMACIJU
        String actualPageTitle = readText(pageTitleBy);                                 // DA SMO NA PLP STRANI ALI U OVOM SLUCAJU IMAMO POTVRDU POREDJENJEM IMENA STRANICA
        verifyTextIsTheSame(expectedPageTitle, actualPageTitle);
        return this;
    }
    public ProductsListPage navigateToProductDetailsPageRandom(){
        clickOnRandomElementFromList(itemNamesBy);
        return this;
    }



}