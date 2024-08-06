package com.qa.italoguasti.seleniumtest.pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage {
    // Locators
    private By menuDressesLocator = By.cssSelector("#block_top_menu > ul > li:nth-child(2) > a");
    private By subMenuCasualDressesLocator = By
            .cssSelector("#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1) > a");
    private By titlePageCasualDressesLocator = By.className("cat-name");

    // Posicionar o mouse em cima do hover e depois clicar na próxima opção
    public void viewCasualDressesPage() {
        if (super.isDisplayed(menuDressesLocator)) {
            super.actionMovieToElementPerform(menuDressesLocator);
            super.actionMovieToElementClickPerform(subMenuCasualDressesLocator);
        } else {
            System.out.println("menu dresses was not found");
        }
    }

    public String getTitlePage() {
        return super.getText(titlePageCasualDressesLocator);
    }
}
