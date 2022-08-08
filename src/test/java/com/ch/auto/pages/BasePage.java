package com.ch.auto.pages;


import com.ch.auto.utils.PropertiesHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BasePage {

    private PropertiesHelpers propertiesHelpers = new PropertiesHelpers();
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(propertiesHelpers.getProperty("timeout"))));
    }

    /**
     *Performs click operation
     *
     * @param by
     */
    protected void click(By by) {
        waitUntilVisible(by).click();
    }

    /**
     *Performs click operation
     *
     * @param element
     */
    protected void click(WebElement element) {
        waitUntilVisible(element).click();
    }

    /**
     * Explicitly waits for the element to be visible and enters the text
     *
     * @param by
     * @param text
     */
    protected void enterText(By by, String text) {
        waitUntilVisible(by).sendKeys(text);
    }

    /**
     *Explicitly waits for the element to be visible
     *
     * @param by
     * @return
     */
    protected WebElement waitUntilVisible(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    /**
     *Explicitly waits for the element to be visible
     *
     * @param element
     * @return
     */
    protected WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     *Performs a scroll within a given element
     *
     * @param element
     */
    protected void scrollUntilElementVisible(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    /**
     *
     * @param index
     */
    protected void switchToWindowByIndex(int index) {
        ArrayList<String> allTabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println(allTabs);
        driver.switchTo().window(allTabs.get(index));
    }
}
