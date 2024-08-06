package com.qa.italoguasti.seleniumtest.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    // Locators
    private By emailAddressLocator = By.id("email");
    private By passwordLocator = By.name("passwd");
    private By submitBtnLocator = By.xpath("//*[@id=\"SubmitLogin\"]");
    private By tahMyAccountLocator = By.tagName("h1");

    // Criado o método login
    public void signin() {
        if (super.isDisplayed(emailAddressLocator)) {
            super.type("camilajavadev123@gmail.com", emailAddressLocator);
            super.type("123456@Ca", passwordLocator);
            super.click(submitBtnLocator);
        } else {
            System.out.println("email textbox was not present");
        }
    }

    // Conferindo pela h1 se o teste entrou na página esperada "MY ACCOUNT"
    public String getMyAccountMessage() {
        return super.getText(tahMyAccountLocator);
    }
}
