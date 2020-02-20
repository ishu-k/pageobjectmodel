package com.pageobject.pages;

import com.pageobject.driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class ProductDescriptionPage extends DriverFactory {
          public void selectDropDown(int increase) throws InterruptedException {
              Select increase1=new Select(driver.findElement(By.cssSelector("select[class='ProductCard__quantitySelect__2y1R3']")));
              increase1.selectByIndex(increase);
              Thread.sleep(5000);
          }
    public  double priceCheckSingle ()
    {
        String price= driver.findElement(By.xpath("//div[contains(text(),'unit price')]/span")).getText();
        System.out.println(price);
        // price.substring()
        String convert=price.replaceAll("£"," ");
        double d= Double.parseDouble(convert);
        System.out.println(d);
        double expected=(d*2);
        System.out.println(expected);
        return expected;
    }



}
