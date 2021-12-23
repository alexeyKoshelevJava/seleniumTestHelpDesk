package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyTickets extends AbstractPage {
    @FindBy(xpath = "//table[@class='table table-sm table-border']//h3")
    private WebElement ticketsName;
    @FindBy(xpath = "//td[@id='ticket-description']/p")
    private WebElement description;

    public String getTicketsName() {
        return ticketsName.getText();
    }

    public String getDescription() {
        return description.getText();
    }

}
