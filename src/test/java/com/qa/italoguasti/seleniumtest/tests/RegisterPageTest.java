package com.qa.italoguasti.seleniumtest.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.italoguasti.seleniumtest.pages.RegisterPage;

public class RegisterPageTest {
    private RegisterPage registerPage;
    private final String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    @BeforeEach
    void setUp() throws Exception {
        this.registerPage = new RegisterPage();
        this.registerPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.registerPage.quitWebDriver();
    }

    @Test
    void testName() {
        // When
        this.registerPage.insertEmailToRegister();

        // Then
        String expected = "test01@qa.com";
        String actual = this.registerPage.getEmailNewAccount();
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
	void test2() {
		//when
		this.registerPage.fillOutForm();
		
		//then
		String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
		String actual = this.registerPage.getWelcomeMessage();
		Assertions.assertEquals(expected, actual);
		
		String actualUrl = this.registerPage.getCurrentUrl();
		Assertions.assertFalse(this.URL.equals(actualUrl));
	}

}
