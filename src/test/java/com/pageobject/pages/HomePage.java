package com.pageobject.pages;

import com.pageobject.driver.DriverFactory;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import  com.pageobject.Hooks;

import java.util.concurrent.TimeUnit;

public class HomePage extends DriverFactory {

    public void doSearch(String searchTerm) throws InterruptedException {

        driver.findElement(By.cssSelector("input[data-test='search-input']")).sendKeys(searchTerm);

        driver.findElement(By.cssSelector("button[type='submit']")).click();

        Thread.sleep(4000);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();

    }
}

