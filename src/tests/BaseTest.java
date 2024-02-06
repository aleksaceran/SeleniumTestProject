package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
    public WebDriver driver;
    String validUsername = "standard_user";
    String validPassword = "secret_sauce";

    @Before
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "C:\\Users\\Aleksa\\Desktop\\SeleniumTestProject 15 dan\\lib");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    
}
