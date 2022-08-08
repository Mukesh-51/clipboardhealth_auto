package com.ch.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailsPage extends BasePage {

    private WebDriver driver;
    @FindBy(xpath = "//h1[contains(text(),'About this item')]")
    private WebElement aboutThisItemTxt;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public ProductDetailsPage switchToProductWindowByIndex(int index) {
        switchToWindowByIndex(1);
        return this;
    }


    public boolean isAboutThisItemDisplayed() {
        scrollUntilElementVisible(aboutThisItemTxt);
        return aboutThisItemTxt.isDisplayed();
    }

    public ArrayList<String> getAboutProduct() {
        ArrayList<String> aboutProduct = new ArrayList<>();
        List<WebElement> lists = driver.findElements(By.xpath("//div[@id='feature-bullets']//li"));
        for (WebElement list : lists) {
            aboutProduct.add(list.getText());
        }
        return aboutProduct;
    }
}
