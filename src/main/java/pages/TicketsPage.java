package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TicketsPage extends AbstractPage {

    private Select select = new Select(driver.findElement(By.xpath("//select[@name='queue']")));
    @FindBy(xpath = "//input[@name='title']")
    private WebElement summaryOfTheProblem;

    @FindBy(xpath = "//textarea[@id='id_body']")
    private WebElement descriptionOfYourIssue;

    private Select priority = new Select(driver.findElement(By.xpath("//select[@id='id_priority']")));
    @FindBy(xpath = "//input[@id='id_due_date']")
    private WebElement dueOn;
    @FindBy(xpath = "//a[@class='ui-datepicker-prev ui-corner-all']")
    private WebElement month;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[5]")
    private WebElement day;
    @FindBy(xpath = "//input[@id='id_attachment']")
    private WebElement buttonAttachFile;
    @FindBy(xpath = "//input[@id='id_submitter_email']")
    private WebElement email;
    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg btn-block']")
    private WebElement submit;


    public void toСhooseQueue(String value) {
        select.selectByVisibleText(value);
    }

    public void describeSummaryOfTheProblem(String value) {

        summaryOfTheProblem.sendKeys(value);
    }

    public void describeOfYourIssues(String value) {
        descriptionOfYourIssue.sendKeys(value);


    }

    public void toChosePriority(String value) {

        priority.selectByVisibleText(value);
    }

    public void toChoseDueDate() {
        dueOn.click();


    }

    public void chooseMonth() {
        month.click();
    }

    public void chooseDay() {
        day.click();
    }

    public void pushButtonAttachFile(String path) {
        buttonAttachFile.sendKeys(path);

    }

    public void inputEmail(String value) {
        email.sendKeys(value);
    }

    public void pushSubmit() {
        submit.click();
    }
}