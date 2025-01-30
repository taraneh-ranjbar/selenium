package com.mypwds.seleniumproject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class HomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Define locators
    private By loginButton = By.id("login-btn");  // Example, replace with actual ID
    private By usernameField = By.id("username");  // Example, replace with actual ID
    private By passwordField = By.id("password");  // Example, replace with actual ID
    private By submitButton = By.id("submit-btn");  // Example, replace with actual ID

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Navigate to Home Page
    public void openHomePage() {
        driver.get("https://mypwds.com");
    }

    // Perform Login
    public void login(String username, String password) {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(submitButton).click();
    }

    // Validate Login Success (Example)
    public boolean isLoginSuccessful() {
        return wait.until(ExpectedConditions.urlContains("dashboard"));
    }

    public void takeScreenshot(String testName) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("screenshots/" + testName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
