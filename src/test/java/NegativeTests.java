import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NegativeTests extends Utils {


    @Test
    public void searchNotExistPage() {
        driver.findElement(topMenu.getSearchInputButton()).click();
        try {
            searchMenu.searchInputText("111");
        } catch (Exception e) {
            assertEquals(searchMenu.getNoResultException(), e.getMessage());
        }
    }

}
