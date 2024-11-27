package com.bonfatti.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    @iOSXCUITFindBy(xpath = "tab_grid_investments")
    public WebElement btnAllow;
    @AndroidFindBy(xpath = "(//android.widget.HorizontalScrollView[@resource-id=\"br.com.ps.myaccount.dev:id/homeGridTabLayout\"])[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.view.ViewGroup")
    @iOSXCUITFindBy(xpath = "tab_grid_investments")
    public WebElement btnInvestments;

    @AndroidFindBy(xpath= "(//android.widget.LinearLayout[@resource-id=\"br.com.ps.myaccount.dev:id/container\"])[1]")
    @iOSXCUITFindBy(xpath = "btn_grid_investment")
    public WebElement btnApplayMoney;

    @AndroidFindBy(id = "btn_secondary")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther")
    public WebElement btnFixedIncome;

    @AndroidFindBy(id = "btn_secondary")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Fixa\"]")
    public WebElement titleFixed;

}
