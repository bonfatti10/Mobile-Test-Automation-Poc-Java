package com.bonfatti;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;


import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Hooks {
    private static AppiumDriverLocalService service;
    private static Hooks INSTANCE;
    private AppiumDriver driver;
    private String platform;

    private Hooks() {
    }

    public static Hooks getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Hooks();
            INSTANCE.initDriver();
        }
        return INSTANCE;
    }

    public AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("O driver não foi inicializado. Chame o método initDriver() antes de acessar o driver.");
        }
        return driver;
    }

    private void initDriver() {

        platform = System.getProperty("plataforma");
        System.out.println("Em execução a plataforma é: " + platform);

        if (platform == null) {
            throw new IllegalStateException("A propriedade 'plataforma' não foi definida. Defina 'plataforma' como 'android', 'ios', 'androidfarm' ou 'iosfarm'.");
        }

        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {
            switch (platform) {
                case "android":
                    capabilities.setCapability("platformName", "Android");
                    capabilities.setCapability("automationName", "UIAutomator2");
                    capabilities.setCapability("platformVersion", "13");
                    capabilities.setCapability("appPackage", "br.com.ps.myaccount.dev");
                    capabilities.setCapability("appActivity", "br.com..myaccount.launcher.presentation.LauncherActivity");
                    capabilities.setCapability("deviceName", "emulator-5554");
                    capabilities.setCapability("noReset", "false");
                    driver = new AndroidDriver<>(new URL("http://localhost:4723/"), capabilities);
                    break;
                case "ios":
                    capabilities.setCapability("app", "/Users/cbonfatti/Desktop/LoginExample.app");
                    capabilities.setCapability("deviceName", "iPhone 15 Pro Max");
                    capabilities.setCapability("platformName", "iOS");
                    capabilities.setCapability("platformVersion", "17.2");
                    capabilities.setCapability("automationName", "XCUITest");
                    capabilities.setCapability("noReset", "false");
                    driver = new IOSDriver<>(new URL("http://localhost:4723/"), capabilities);
                    break;
                case "androidfarm":
                    capabilities.setCapability("browserstack.user", "");
                    capabilities.setCapability("browserstack.key", "");
                    capabilities.setCapability("app", "bs://5e4ade09ea64353e6eadad80b3b9952435418458");
                    capabilities.setCapability("device", "Google Pixel 3");
                    capabilities.setCapability("os_version", "9.0");
                    capabilities.setCapability("project", "Renda Fixa Android");
                    driver = new AppiumDriver<>(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
                    break;
                case "iosfarm":
                    capabilities.setCapability("browserstack.user", "cbonfatti_8pfAtv");
                    capabilities.setCapability("browserstack.key", "hM7xPTXTD6vbZyCe9kA1");
                    capabilities.setCapability("app", "bs://ab04907053cfca76d35f251cb033c47aa2fdda");
                    capabilities.setCapability("device", "iPhone 14");
                    capabilities.setCapability("os_version", "16");
                    capabilities.setCapability("autoAcceptAlerts", true);
                    HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
                    browserstackOptions.put("networkLogs", "true");
                    driver = new IOSDriver<>(new URL("http://hub.browserstack.com/wd/hub"), capabilities);
                    Duration duration = Duration.ofSeconds(15);
                    long seconds = duration.getSeconds();
                    driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
                    break;
                default:
                    throw new IllegalStateException("Plataforma não encontrada. Utilize android, ios, androidfarm ou iosfarm.");
            }
        } catch (WebDriverException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inicializar o driver remoto: " + e.getMessage(), e);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao inicializar o driver: URL inválida", e);
        }
    }
    public static void appiumStart(){
//        service = AppiumDriverLocalService.buildDefaultService();
//        service.start();
        try {
            // Crie um processo para executar o comando "appium"
            ProcessBuilder processBuilder = new ProcessBuilder("appium");

            // Redirecione a saída padrão e a saída de erro para o console
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            processBuilder.redirectError(ProcessBuilder.Redirect.INHERIT);

            // Inicie o processo
            Process process = processBuilder.start();

            // Aguarde o término do processo
            process.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Appium em execução");
    }

    public static void appiumServerDown() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.stop();
        System.out.println("Appium Down");
    }

}
