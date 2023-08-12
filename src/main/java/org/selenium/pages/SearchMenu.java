package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchMenu {
    private final By searchInput = By.className("DocSearch-Input");
    private final By noResults = By.className("DocSearch-NoResults");

    private final String noResultException = "Expected information does not exist on site, check input";

    private final WebDriver driver;

    public SearchMenu(WebDriver driver) {
        this.driver = driver;
    }

    public String getNoResultException() {
        return noResultException;
    }

    public void searchInputText(String filter) throws Exception {
        driver.findElement(searchInput).sendKeys(filter);
        By foundItemContainer = By.className("DocSearch-Hit-Container");
        Thread.sleep(2000);
        if (!driver.findElements(noResults).isEmpty()) {
            throw new Exception(noResultException);
        } else {
            driver.findElement(foundItemContainer).click();
        }
    }

}
