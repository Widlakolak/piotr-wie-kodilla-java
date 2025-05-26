package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class FacebookTestingApp {

    private static final String XPATH_WAIT_FOR = "//html/body/div[3]/div[2]/div/div/div/div";
    private static final String XPATH_COOKIES = "//span[contains(text(), 'Odrzuć opcjonalne pliki cookie')]";
    private static final String XPATH_ACCOUNT = "//a[@data-testid='open-registration-form-button']";
    private static final String XPATH_DAY = "//select[@id='day']";
    private static final String XPATH_MONTH = "//select[@id='month']";
    private static final String XPATH_YEAR = "//select[@id='year']";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driver != null;
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement rejectCookies = driver.findElement(By.xpath(XPATH_COOKIES));
        rejectCookies.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        WebElement newAccount = driver.findElement(By.xpath(XPATH_ACCOUNT));
        newAccount.click();

        while (!driver.findElement(By.xpath(XPATH_WAIT_FOR)).isDisplayed());

        WebElement rejectCookiesAgain = driver.findElement(By.xpath(XPATH_COOKIES));
        rejectCookiesAgain.click();

        WebElement daySelect = driver.findElement(By.xpath(XPATH_DAY));
        Select dayList = new Select(daySelect);
        dayList.selectByValue("3");

        WebElement monthSelect = driver.findElement(By.xpath(XPATH_MONTH));
        Select monthList = new Select(monthSelect);
        monthList.selectByValue("11");

        WebElement yearSelect = driver.findElement(By.xpath(XPATH_YEAR));
        Select yearList = new Select(yearSelect);
        yearList.selectByValue("1990");
    }
}
