package com.bonfatti.tests;

import com.bonfatti.Hooks;
import io.appium.java_client.AppiumDriver;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static com.bonfatti.Hooks.appiumStart;


public class BaseTest  {

    protected static AppiumDriver driver;

    @BeforeAll
    public static void initializeAppium() {
        appiumStart();
    }


    @Before
    public void setUp() {

        driver = Hooks.getInstance().getDriver();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        System.out.print("Teste finalizado!");
        Hooks.appiumServerDown();
    }
}
