package tests;

import org.junit.Test;

import pages.LoginPage;
import pages.ProductsListPage;

public class LoginTests extends BaseTest {

    String expectedErrorEmptyUsername = "Epic sadface: Username is required";
    String expectedErrorEmptyPassword = "Epic sadface: Password is required";
    String wrongCredential = "bilo sta sto nije validno";
    String expectedErrorWrongCredentials = "Epic sadface: Username and password do not match any user in this service";
    String lockedUsername = "locked_out_user";
    String expectedErrorLockedUser = "Epic sadface: Sorry, this user has been locked out.";

    @Test
    public void verifySucessfullLogin(){                                        //USPESNO LOGOVANJE
        LoginPage loginPage = new LoginPage(driver);                            //POZIVANJE OBJEKTA BROWSERA
        ProductsListPage productsListPage = new ProductsListPage(driver);       //POZIVANJE OBJEKTA PLP

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.verifySuccessfulLogin();
    }

    @Test
    public void verifyUnsuccessfulLoginEmptyUsername(){                         //BEZ USERNAME
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.login("", validPassword);
        loginPage.verifyUnsuccessfulLogin(expectedErrorEmptyUsername);
    }

    @Test
    public void verifyUnsuccessfulLoginEmptyPassword(){                         //BEZ SIFRE
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, "");
        loginPage.verifyUnsuccessfulLogin(expectedErrorEmptyPassword);
    }

    @Test
    public void verifyUnsuccessfulLoginWrongCredentials(){                      //POGRESNI KREDENCIJALI
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(wrongCredential, wrongCredential);
        loginPage.verifyUnsuccessfulLogin(expectedErrorWrongCredentials);
    }

    @Test
    public void verifyUnsuccessfulLoginLockedUser(){                            //ZAKLJUCAN USER
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(lockedUsername, validPassword);
        loginPage.verifyUnsuccessfulLogin(expectedErrorLockedUser);
    }

    @Test
    public void verifySuccessfulLogout(){                                       //LOGOUT
        LoginPage loginPage = new LoginPage(driver);
        ProductsListPage productsListPage = new ProductsListPage(driver);

        loginPage.goToLoginPage();
        loginPage.login(validUsername, validPassword);
        productsListPage.expandMenu();
        productsListPage.logout();
        loginPage.verifySuccessfulLogout();
    }
    
}
