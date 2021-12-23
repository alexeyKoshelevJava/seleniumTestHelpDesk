package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfidentialPage extends AbstractPage {
    @FindBy(xpath = "//input[@id='search_query']")
    private WebElement searchWindow;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    private WebElement buttonGo;

    public void inputTicketsName(String name) {
        searchWindow.sendKeys(name);

    }
    public void pushButtonGO(){
        buttonGo.click();
    }

}

