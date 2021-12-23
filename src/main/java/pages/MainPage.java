package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(css = "a[href^='/tickets/submit/']")
    private WebElement newTicket;
    @FindBy(xpath = "//a[@class='nav-link dropdown-toggle']")
    private WebElement logIn;


    public void goToTickets() {
        newTicket.click();

    }

    public void goToLogPage() {
        logIn.click();
    }

}
