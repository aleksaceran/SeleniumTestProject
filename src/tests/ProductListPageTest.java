package tests;

import org.junit.Test;

import pages.CartPage;
import pages.LoginPage;
import pages.ProductsListPage;

public class ProductListPageTest extends BaseTest{
    String expectedCartPageTitle = "Your Cart";
    String expectedFirstItemNameLowToHigh = "Sauce Labs Onesie";
    String expectedFirstItemNameHighToLow = "Sauce Labs Fleece Jacket";
    
        @Test
        public void verifyCarNavigation(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);
        CartPage cartPage = new CartPage(driver);
        

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.navigateToCartPage();
        cartPage.verifyCartNavigation(expectedCartPageTitle);
        }

        @Test
        public void verifySortByPriceLowToHigh(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.sortProducts("lohi");
        productsListPage.verifyFirstItemName(expectedFirstItemNameLowToHigh);
        }
        @Test
        public void verifySortByPriceHighToLow(){
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.sortProducts("hilo");
        productsListPage.verifyFirstItemName(expectedFirstItemNameHighToLow);
        }
    

        @Test
        public void countProducts(){
            LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);

            // koristio sam ovaj lokator "By productSelector = By.className("inventory_item")";
            loginPage.goToLoginPage();
            loginPage.login(validUsername, validPassword);
            productsListPage.countProducts();
        }
        @Test
        public void navigateToPDP(){                                                              
            LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);
            loginPage.goToLoginPage();
            loginPage.login(validUsername, validPassword);
            productsListPage.navigateToPDP();                                                     // NAVIGIRAMO SE NA PDP KLIKOM NA BACKPACK
        }
        @Test
        public void addingToCartFromPLP(){                                                        // ADD TO CART ( DODA, ODE NA CART I VERIFY DA JE DODATO U CART)
            LoginPage loginPage = new LoginPage(driver);
            ProductsListPage productsListPage = new ProductsListPage(driver);
            CartPage cartPage = new CartPage(driver);
            loginPage.goToLoginPage();
            loginPage.login(validUsername, validPassword);
            productsListPage.addToCartFunction();                                                 // ADD TO CART SA PDP STRANE
            productsListPage.navigateToCartPage();                                                // NAVIGACIJOM PUTEM CART IKONICE ODLAZIMO NA CART PAGE
            cartPage.verifyCartNavigation("Your Cart");                         // RADIMO VERIFIKACIJU PROVEROM IMENA STRANICE
            cartPage.verifyThatCertainItemIsInCart("Sauce Labs Backpack");       // RADIMO VERIFIKACIJU DA JE ODREDJENI ITEM U CARTU

        }

       
}