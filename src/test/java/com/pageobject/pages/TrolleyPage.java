package com.pageobject.pages;

import com.pageobject.driver.DriverFactory;
import org.openqa.selenium.By;

public class TrolleyPage extends DriverFactory {

    public void addToTrolley() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("button[data-test='component-att-button']")).click();
    }


    public void goToTrolley() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.cssSelector(".xs-row a[data-test='component-att-button-basket']")).click();
    }

    public String getProductInTrolley() throws InterruptedException {
        Thread.sleep(5000);
        return driver.findElement(By.cssSelector(".ProductCard__content__9U9b1.xsHidden.lgFlex .ProductCard__titleLink__1PgaZ")).getText();
    }
}
