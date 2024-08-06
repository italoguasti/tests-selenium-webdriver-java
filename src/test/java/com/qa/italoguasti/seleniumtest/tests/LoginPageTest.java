package com.qa.italoguasti.seleniumtest.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.italoguasti.seleniumtest.pages.LoginPage;

class LoginPageTest {
    private LoginPage loginPage;
    private final String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";

    @BeforeEach
    void setUp() throws Exception {
        this.loginPage = new LoginPage();
        this.loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.loginPage.quitWebDriver();
    }

    @Test
    void test() {
        // When
        this.loginPage.signin();

        // Then
        Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals("MY ACCOUNT"));
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(this.URL));
    }
}
