package com.ch.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='hm-icon-label' and contains(text(),'All')]")
    private WebElement allMenuItem;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public HomePage clickOnAllMenu() {
        click(allMenuItem);
        return this;
    }

    public <T> T scrollByProductTypeAndClick(String productType) {
        By element = By.xpath(String.format("//div[contains(text(),'%s')]", productType));
        scrollUntilElementVisible(driver.findElement(element));
        click(element);
        return nextPage(productType);
    }

    @SuppressWarnings("unchecked")
    private <T> T nextPage(String type) {
        switch (type.toLowerCase()) {
            case "tv, appliances, electronics":
            default:
                return (T) new TelevisionSubMenuPage(driver);
        }
    }

}
