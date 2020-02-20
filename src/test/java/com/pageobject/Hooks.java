package com.pageobject;

import com.pageobject.driver.DriverFactory;
import org.junit.After;
import org.junit.Before;

public class Hooks {
    DriverFactory factory=new DriverFactory();
    @Before
    public void setup()
    {
        factory.openBrowser();
        factory.navigateTo("https://www.argos.co.uk/");
        factory.maxiBrowser();
    }
    @After
    public void tearDown()
    {
        factory.closeBrowser();
    }

}
