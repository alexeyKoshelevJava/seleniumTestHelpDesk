package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement user;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;
    @FindBy(xpath = "//input[@class='btn btn-lg btn-primary btn-block']")
    private WebElement buttonLogin;


    public void inputUser(String us) {
        user.sendKeys(us);

    }

    public void inputPassword(String p) {
        password.sendKeys(p);
    }

    public void pushLogin() {
        buttonLogin.click();
    }
}
