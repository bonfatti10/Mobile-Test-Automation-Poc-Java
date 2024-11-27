package com.bonfatti.actions;

import com.bonfatti.screens.BaseScreen;
import com.bonfatti.screens.HomeScreen;

public class HomeAction extends BaseScreen {
    HomeScreen home = new HomeScreen();


    public void btnAllowClick() {
        home.btnAllow.click();
    }

    public void btnInvestimentsClick() {
        home.btnInvestments.click();
    }
    public void btnFixeClick() {
        home.btnApplayMoney.click();
    }

    public void homeToInvestments() {
        btnAllowClick();
        btnInvestimentsClick();
        btnFixeClick();
    }
}
