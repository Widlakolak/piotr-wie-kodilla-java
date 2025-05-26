package com.kodilla.testing2.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.File;


public class WebDriverConfig {
    public final static String EDGE = "EDGE_DRIVER";
    public final static String CHROME = "CHROME_DRIVER";

    public static WebDriver getDriver(final String driver) {
        System.setProperty("webdriver.edge.driver", "c:\\Selenium-drivers\\Edge\\msedgedriver.exe");
        System.setProperty("webdriver.chrome.driver", "c:\\Selenium-drivers\\Chrome\\chromedriver.exe");

        if (driver.equals(EDGE)) {
            EdgeOptions options = getEdgeOptions();
            return new EdgeDriver(options);
        } else if (driver.equals(CHROME)) {
            return new ChromeDriver();
        } else {
            return null;
        }
    }

    private static EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-first-run");
        options.addArguments("--disable-features=EdgeImplicitSignin");
        options.addArguments("--disable-features=msSignInAccounts");
        options.addArguments("--disable-default-apps");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-popup-blocking");

        String userDataDir = "C:\\Selenium-drivers\\Edge\\TempProfile_" + System.currentTimeMillis();
        new File(userDataDir).mkdirs();
        options.addArguments("--user-data-dir=" + userDataDir);

        options.setExperimentalOption("useAutomationExtension", false);
        return options;
    }
}

//        if (driver.equals(EDGE)) {
//            return new EdgeDriver();
//        } else if (driver.equals(CHROME)) {
//            return new ChromeDriver();
//        } else {
//            return null;
//        }