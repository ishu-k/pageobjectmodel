package com.pageobject;

import com.pageobject.pages.HomePage;
import com.pageobject.pages.ProductDescriptionPage;
import com.pageobject.pages.ResultPage;
import com.pageobject.pages.TrolleyPage;
import org.junit.Test;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SmokeTest extends Hooks {

    private HomePage homePage = new HomePage();
    ResultPage resultsPage = new ResultPage();
    private TrolleyPage trolleyPage= new TrolleyPage();
    ProductDescriptionPage descriptionPage=new ProductDescriptionPage();

    @Test
    public void searchTest() throws InterruptedException {
        String searchTerm="puma";
        homePage.doSearch(searchTerm);
        assertThat(homePage.getCurrentUrl(), endsWith(searchTerm));
        System.out.println(homePage.getCurrentUrl());
        List<String> actualProductList = resultsPage.getAllProductNames();
        for (String product: actualProductList){
            assertThat(product.toLowerCase(),containsString(searchTerm));
        }
        String actualTitle = resultsPage.getSearchTitle();
        assertThat(actualTitle, is(equalToIgnoringCase(searchTerm)));
    }

    @Test
    public void basketTest() throws InterruptedException {
        homePage.doSearch("nike");
        String selectedProductName =resultsPage.selectAnyProduct();
        trolleyPage.addToTrolley();
        Thread.sleep(5000);
        trolleyPage.goToTrolley();
        String actual = trolleyPage.getProductInTrolley();
        System.out.println(actual);
        assertThat(actual,equalTo(selectedProductName));
    }

    @Test
    public void challengeTask() throws InterruptedException {
        homePage.doSearch("nike");
        String allProducts=resultsPage.selectAnyProduct();
        trolleyPage.addToTrolley();
        Thread.sleep(4000);
        trolleyPage.goToTrolley();
        Thread.sleep(4000);
       // descriptionPage.priceCheckSingle();
        descriptionPage.selectDropDown(1);
        Thread.sleep(5000);
        descriptionPage.priceCheckSingle();
        resultsPage.totalPrice();
    }
    @Test
    public void challengeTask2() throws InterruptedException {
       homePage.doSearch("puma");
        String allProducts=resultsPage.selectAnyProduct();
        trolleyPage.addToTrolley();
        trolleyPage.continueShopping();
        homePage.doSearch("adidas");
        String onemore=resultsPage.selectAnyProduct();
        trolleyPage.addToTrolley();
        trolleyPage.goToTrolley();
        resultsPage.numberofProductsInBasket();

    }
}
