package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

   public  BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitElementToBeVisible(By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }

    public void waitElementToBeClickable(By elementBy){
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public void enterText(By elementBy, String text) {
        waitElementToBeClickable(elementBy);
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void clickElement(By elementBy){
        waitElementToBeClickable(elementBy);
        driver.findElement(elementBy).click();
    }

    public String readText(By elementBy){
        waitElementToBeVisible(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void verifyTextIsTheSame(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }

    public void verifyElementIsVisible(By elementBy){
        boolean isVisible;

        //probaj da uradis nesto
        try {
            waitElementToBeVisible(elementBy);
            isVisible = driver.findElement(elementBy).isDisplayed();
        } 
        //AKO naidjes na gresku, izvrsi catch blok
        catch (Exception e) {
            isVisible = false;
        }

        Assert.assertTrue(isVisible);
    }
    public void waitElementsToBeVisible(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public int countNumberOfElements(By elementBy){
        waitElementsToBeVisible(elementBy);
        return driver.findElements(elementBy).size();
    }
    public void verifyNumberOfElements(int expectedNum, int actualNum){
        Assert.assertEquals(expectedNum, actualNum);
    }
    public void selectOptionByValue( By elementBy, String value){
        waitElementToBeVisible(elementBy);
        Select select = new Select(driver.findElement(elementBy));
        select.selectByValue(value);
    }
   
    
}
