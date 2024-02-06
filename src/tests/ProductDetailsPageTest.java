package tests;

import org.junit.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.ProductsListPage;

public class ProductDetailsPageTest extends BaseTest{
    String expectedPageTitle = "Products";

    
    @Test
    public void verifyLoadedPDP(){                                                  
        LoginPage loginPage = new LoginPage(driver);                                
        ProductsListPage productsListPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.navigateToPDP();                                                 // NAVIGACIJA NA PDP I NAZAD NA PLP POTVRDOM SUCCESS LOGIN METODE KORISTECI
        productDetailsPage.navigateToPLP();                                               // 'YOUR PRODUCTS' KOJI SMO CITALI IZ //span[@class='title']
        productsListPage.verifySuccessfulLogin();
        productsListPage.verifyNavigateToPLP("Products");               // DODATNA VERIFIKACIJA POREDJENJEM NASLOVA STRANICA(ZBUNJUJE ME STO IMAM OVU METODU I U PLP I PDP)
                                                                                            
    }
    @Test
    public void addToCartFromPDP(){
        LoginPage loginPage = new LoginPage(driver);                               
        ProductsListPage productsListPage = new ProductsListPage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        CartPage cartPage = new CartPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.navigateToPDP();                                                 // NAVIGIRAMO SE NA PDP KLIKOM NA BACKPACK U OVOM SLUCAJU
        productDetailsPage.addToCartFunction();                                           // ADD TO CART SA PDP STRANE
        productDetailsPage.navigateToCartPage();                                          // NAVIGACIJOM PUTEM CART IKONICE ODLAZIMO NA CART PAGE
        cartPage.verifyCartNavigation("Your Cart");                     // RADIMO VERIFIKACIJU PROVEROM IMENA STRANICE
        cartPage.verifyThatCertainItemIsInCart("Sauce Labs Backpack");   // RADIMO VERIFIKACIJU DA JE ODREDJENI ITEM U CARTU



    }

    
    

}
