package com.pageobject;

import com.pageobject.pages.HomePage;
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
}
