package com.mypwds.seleniumproject.tests;

import com.mypwds.seleniumproject.config.WebDriverConfig;
import com.mypwds.seleniumproject.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class HomePageTest {
    @Autowired
    private WebDriver driver;

    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage(driver);
        homePage.openHomePage();
    }

    @Test
    public void testLogin() {
        homePage.login("testuser", "password123");
        assertTrue(homePage.isLoginSuccessful(), "Login should be successful.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
