package com.ch.auto.tests;

import com.ch.auto.pages.HomePage;
import com.ch.auto.pages.TelevisionSubMenuPage;
import com.ch.auto.pages.ProductDetailsPage;
import com.ch.auto.pages.ProductListPage;
import lombok.extern.log4j.Log4j;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

@Log4j
public class ProductDetailsTest extends BaseTest {

    @Test(description = "Get the details of the second highest priced television of Samsung")
    public void getDetailsOfSecondHighPricedProduct() {
        TelevisionSubMenuPage televisionSubMenuPage = new HomePage(driver)
                .clickOnAllMenu()
                .scrollByProductTypeAndClick("TV, Appliances, Electronics");
        televisionSubMenuPage.clickOnMenuItem("Televisions");

        new ProductListPage(driver).clickOnProductByName("Samsung")
                .sortByFilter("Price: High to Low")
                .clickOnProductByCellNumber("2");

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        boolean isAboutThisItemDisplayed = productDetailsPage
                .switchToProductWindowByIndex(1)
                .isAboutThisItemDisplayed();

        Assert.assertTrue(isAboutThisItemDisplayed, "About this item section is not present!");

        ArrayList<String> aboutProduct = productDetailsPage.getAboutProduct();
        for (String productDetail : aboutProduct) {
            log.info(productDetail);
        }
    }
}
