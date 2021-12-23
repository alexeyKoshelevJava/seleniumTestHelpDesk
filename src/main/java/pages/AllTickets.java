package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllTickets extends AbstractPage{
   @FindBy(xpath = "//div[@class='tickettitle']/a")
    private WebElement windowWithTicketsName;

   public void goToMyTickets(){
       windowWithTicketsName.click();

   }
}
