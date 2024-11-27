package com.bonfatti.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {

    @AndroidFindBy(accessibility = "Já tenho conta, botão")
    @iOSXCUITFindBy(id = "btn_secondary")
    public WebElement btnHaveAccount;

    @AndroidFindBy(id = "br.com.ps.myaccount.dev:id/ds_ps_input_inputText")
    @iOSXCUITFindBy(id = "txt_input_username")
    public WebElement fieldUserName;

    @AndroidFindBy(accessibility = "Continuar, botão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continuar\"]")
    public WebElement btnContinue;

    @AndroidFindBy(id = "br.com.ps.myaccount.dev:id/ds_ps_input_inputText")
    @iOSXCUITFindBy(accessibility = "txt_input_password")
    public WebElement fieldPassword;

    @AndroidFindBy(accessibility= "Acessar conta, botão")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Acessar conta\"]")
    public WebElement btnAccessAccount;

    @AndroidFindBy(id = "btn_secondary")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Done\" and @label=\"concluído\"]")
    public WebElement btnOk;

}
