package org.selenium.pages;

import org.openqa.selenium.By;

public class PageObjectModels {

    private final By title = By.linkText("Page object models");

    public By getTitle() {
        return title;
    }


}
