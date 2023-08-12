package org.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TopMenu {

    private final By aboutPopUp = By.linkText("About");
    private final By downloads = By.linkText("Downloads");
    private final By documentation = By.linkText("Documentation");
    private final By projects = By.linkText("Projects");
    private final By support = By.linkText("Support");
    private final By blog = By.linkText("Blog");

    private final By searchInputButton = By.className("DocSearch-Button-Placeholder");

    private final WebDriver driver;

    public TopMenu(WebDriver driver) {
        this.driver = driver;
    }

    public By getDownloads() {
        return downloads;
    }

    public By getDocumentation() {
        return documentation;
    }

    public By getProjects() {
        return projects;
    }

    public By getSupport() {
        return support;
    }

    public By getBlog() {
        return blog;
    }

    public By getSearchInputButton() {
        return searchInputButton;
    }

    public List<String> getAboutItems() {
        driver.findElement(aboutPopUp).click();
        final By aboutMenu = By.xpath("//div[@class='dropdown-menu show']");
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(d -> d.findElement(aboutMenu));
        final By aboutItem = By.className("dropdown-item");
        return driver.findElement(aboutMenu).findElements(aboutItem)
                .stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
