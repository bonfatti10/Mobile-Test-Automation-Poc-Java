package com.bonfatti.tests;

import com.bonfatti.actions.HomeAction;
import com.bonfatti.actions.LoginAction;
import com.bonfatti.actions.PinRegistrationAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InvestimentMenuTest extends BaseTest {
    LoginAction login = new LoginAction();
    PinRegistrationAction pin = new PinRegistrationAction();
    HomeAction home = new HomeAction();

    @Test
    @DisplayName("Quando o usuario fizer login com sucesso e clicar em Renda Fixa ele deve ver o menu investimento Renda Fixa")
    public void testLogin() throws InterruptedException {
        login.doLogin();
        pin.createPin();
        home.homeToInvestments();
    }
}

