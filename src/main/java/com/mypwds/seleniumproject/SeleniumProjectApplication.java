package com.mypwds.seleniumproject;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.mypwds.seleniumproject.pages.HomePage;

@SpringBootApplication
public class SeleniumProjectApplication {
	
    @Autowired
    private WebDriver driver;
    
    private String username = "testaccount";
    private String password = "!W@nt@N3P@$$w0rd";

	public static void main(String[] args) {
		SpringApplication.run(SeleniumProjectApplication.class, args);
		SeleniumProjectApplication spa = new SeleniumProjectApplication();
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void run() {
		HomePage homePage = new HomePage(driver);
        homePage.openHomePage();
        homePage.login(username, password);
        homePage.isLoginSuccessful();
        homePage.takeScreenshot("myScreenShot.jpg");
        try {
			wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
