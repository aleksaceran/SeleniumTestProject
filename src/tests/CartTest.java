package tests;

import org.junit.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsListPage;

public class CartTest extends BaseTest{
   
    

    @Test
    public void verifyReturnToPLP(){
        LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);
            CartPage cartPage = new CartPage(driver);
            loginPage.goToLoginPage();
            loginPage.login(validUsername, validPassword);
            productsListPage.addToCartFunction();                                                 
            productsListPage.navigateToCartPage();
            cartPage.verifyReturnToPLP();


    }

    @Test
    public void verifyReturnToPDP(){
        LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);
            CartPage cartPage = new CartPage(driver);
            loginPage.goToLoginPage();
            loginPage.login(validUsername, validPassword);                                      //RADI!
            productsListPage.addToCartFunction();                                                 
            productsListPage.navigateToCartPage();
            cartPage.verifyReturnToPDP();
}
    @Test
    public void removeItemFromCart(){
        LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);
            CartPage cartPage = new CartPage(driver);
            loginPage.goToLoginPage();
            loginPage.login(validUsername, validPassword);                                      //RADI!
            productsListPage.addToCartFunction();                                                 
            productsListPage.navigateToCartPage();
            cartPage.removeItemFromCart();


    }
    @Test
    public void navToCheckoutPage(){
            LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);
            CartPage cartPage = new CartPage(driver);
            loginPage.goToLoginPage();                                                                  //RADI!
            loginPage.login(validUsername, validPassword);
            productsListPage.addToCartFunction();                                                 
            productsListPage.navigateToCartPage();
            cartPage.goToCheckoutPage();
            cartPage.verifyCheckoutPage("Checkout: Your Information");
        
    }



}