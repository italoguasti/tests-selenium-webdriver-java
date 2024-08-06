package com.qa.italoguasti.seleniumtest;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicLoginTest {
    private WebDriver driver;

    // antes de iniciar os testes
    @BeforeEach
    void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.automationpractice.pl/index.php?controller=authentication&back=my-account");
    }

    // depois de concluir os testes
    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void test() {
        // inserindo e-mail (por id)
        WebElement emailAddressLocator = driver.findElement(By.id("email"));
        emailAddressLocator.sendKeys("camilajavadev123@gmail.com");

        // inserindo password (por name)
        WebElement passwordElement = driver.findElement(By.name("passwd"));
        passwordElement.sendKeys("123456@Ca");

        // clicando no botão submit (por xpath)
        WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]"));
        submitBtnElement.click();

        // gerando as assertivas (por h1 "my account")
        WebElement tagMyAccount = driver.findElement(By.tagName("h1"));
        String textTagH1 = tagMyAccount.getText();

        Assertions.assertTrue(textTagH1.equals("MY ACCOUNT"));
    }
}
