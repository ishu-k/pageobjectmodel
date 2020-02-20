package com.pageobject.pages;

import com.pageobject.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

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

    public void continueShopping()
    {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement element2= driver.findElement(By.xpath("//a[@class='Buttonstyles__Button-q93iwm-2 guHdak']"));
        element2.click();
        }

    }

