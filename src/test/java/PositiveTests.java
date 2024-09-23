import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PositiveTests extends Utils {

    @Test
    public void checkTopUpMenuExists() throws InterruptedException {
        driver.findElement(topMenu.getDownloads()).click();
        driver.findElement(topMenu.getDocumentation()).click();
        driver.findElement(topMenu.getProjects()).click();
        driver.findElement(topMenu.getSupport()).click();
        driver.findElement(topMenu.getBlog()).click();
        assertTrue(topMenu.getAboutItems().contains("Events"), "Events pop-up item was not found");
        Thread.sleep(1000);
    }


    @Test
    public void checkWelcomeTextExists() {
        driver.findElement(basePage.getLogotype()).click();
        assertEquals(driver.findElement(By.tagName("h1")).getText(), "Selenium automates browsers. That's it!");
    }

    @Test
    public void searchPageObjectModels() throws Exception {
        driver.findElement(topMenu.getDocumentation()).click();
        driver.findElement(topMenu.getSearchInputButton()).click();
        searchMenu.searchInputText("Page object models");
        assertTrue(driver.findElement(pageObjectModels.getTitle()).isDisplayed());
    }
}
