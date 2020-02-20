package com.pageobject.pages;

import com.pageobject.driver.DriverFactory;
import com.pageobject.utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ResultPage  extends DriverFactory {

    public List<String> getAllProductNames()              //get the list of product elements as a string into list
    {
        List<String> productNamesList = new ArrayList<String>();  // collecting in to arraylist
        List<WebElement> productWebElements = isProductsAvailable();
        for (WebElement indProduct : productWebElements) {
            String actual = indProduct.getText();
            productNamesList.add(actual);
        }
        return productNamesList;

    }


    public String getSearchTitle() {
        return driver.findElement(By.className("search-title__term")).getText();

    }
    public String selectAnyProduct(){
        List<WebElement> productWebElements = isProductsAvailable();
        int productSize = productWebElements.size();
        int randomNumber = new Helpers().randomNumberGenerator(productSize);
        WebElement selectedElement = productWebElements.get(randomNumber);
        String selectedProductName = selectedElement.getText();
        selectedElement.click();

        return selectedProductName;

    }

    private List<WebElement> isProductsAvailable() {
        List<WebElement> productWebElements = driver.findElements(By.cssSelector("a[data-test='component-product-card-title']"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(productWebElements.size()==0){
            // fail("Zero products found .....");
            //throw new RuntimeException("zero products found");
            throw new RuntimeException("Zero products found .....");
        }
        return productWebElements;

    }
    public double totalPrice()
    {
        String price1=driver.findElement(By.cssSelector("div.Summary__subTotalLabel__2GphY")).getText();
        System.out.println(price1);
        String actual=price1.replaceAll("£"," ");
        //converting string to double
        double actual1=Double.parseDouble(actual);
        System.out.println(actual1);
        return actual1;
    }
    public int numberofProductsInBasket()
    {
        String expected= driver.findElement(By.xpath("//header[@id='haas-v2']//a[4]/span[1]")).getText();
        System.out.println(expected);
        int actual1=Integer.parseInt(expected);
        return actual1;
    }
    
    
}
