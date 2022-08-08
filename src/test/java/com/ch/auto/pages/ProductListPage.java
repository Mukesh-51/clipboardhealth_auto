package com.ch.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends BasePage {


    private WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Sort by:')]")
    private WebElement sortBy;

    public ProductListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    public ProductListPage clickOnProductByName(String productName) {
        click(By.xpath(String.format("//span[@class='a-size-base a-color-base' and contains(text(),'%s')]", productName)));
        return this;
    }

    public ProductListPage sortByFilter(String filterName) {
        click(sortBy);
        click(By.xpath(String.format("//a[contains(text(),'%s')]", filterName)));
        return this;
    }

    public void clickOnProductByCellNumber(String cellNumber) {
        click(By.xpath(String.format("//div[@data-cel-widget='search_result_%s']//h2//span", cellNumber)));
    }
}
