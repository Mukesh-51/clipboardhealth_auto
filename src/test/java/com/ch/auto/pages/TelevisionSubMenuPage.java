package com.ch.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TelevisionSubMenuPage extends BasePage {

    public TelevisionSubMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnMenuItem(String menuItem) {
        click(By.partialLinkText(menuItem));
    }
}
