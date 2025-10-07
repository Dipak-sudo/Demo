package com.Stepdefination;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import com.Util.Driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
    WebDriver driver;
    
    @Before
    public void setup() throws InterruptedException {
        Driverfactory df = new Driverfactory();
        df.initialiseDriver();   // <-- This creates the driver
        driver = Driverfactory.getDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://tutorialsninja.com/demo/");
    }
    
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();   // quit() already closes all windows
        }
    }}