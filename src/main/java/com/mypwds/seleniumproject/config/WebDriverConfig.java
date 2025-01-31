package com.mypwds.seleniumproject.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebDriverConfig {

    @Bean
    public WebDriver webDriver() {
        // Force WebDriverManager to download the correct version
        WebDriverManager.chromedriver().clearDriverCache();
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");// Maximize browser window
        options.addArguments("--disable-notifications");// Block pop-ups
//        options.addArguments("--headless"); // Run in headless mode (no UI, optional)

        return new ChromeDriver(options);
    }

}
