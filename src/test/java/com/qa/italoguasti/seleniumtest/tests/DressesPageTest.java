package com.qa.italoguasti.seleniumtest.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.qa.italoguasti.seleniumtest.pages.DressesPage;

public class DressesPageTest {
    private DressesPage dressesPage;
    private final String URL = "http://www.automationpractice.pl/index.php";

    @BeforeEach
    void setUp() throws Exception {
        this.dressesPage = new DressesPage();
        this.dressesPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        this.dressesPage.quitWebDriver();
    }

    @Test
    void testName() {
        // When
        this.dressesPage.viewCasualDressesPage();

        // Then
        Assertions.assertEquals("CASUAL DRESSES ", this.dressesPage.getTitlePage());
        Assertions.assertFalse(this.URL.equals(dressesPage.getCurrentUrl()));
    }
}
