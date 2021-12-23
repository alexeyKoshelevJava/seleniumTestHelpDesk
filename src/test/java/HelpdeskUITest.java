import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.*;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    private static final String QUEUE = "Some Product";
    private static final String SUMMARY_PROBLEM = "everything Horrable";
    private static final String YOUR_ISSUE = "I have a black screen";
    private static final String PRIORITY = "1. Critical";
    private static final String PATH = "C:\\Project Lanit\\SileniumHomework6\\seleniumTestHelpDesk\\print_screen.png";
    private static final String EMAIL = "abcdefg@goodle.com";

    @Before
    public void setup() throws IOException {

        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));


        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() throws IOException {
        driver.get(System.getProperty("site.url"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));


        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        mainPage.goToTickets();

        TicketsPage ticketsPage = PageFactory.initElements(driver, TicketsPage.class);
        ticketsPage.toСhooseQueue(QUEUE);
        ticketsPage.describeSummaryOfTheProblem(SUMMARY_PROBLEM);
        ticketsPage.describeOfYourIssues(YOUR_ISSUE);
        ticketsPage.toChosePriority(PRIORITY);
        ticketsPage.toChoseDueDate();
        ticketsPage.chooseMonth();
        ticketsPage.chooseDay();
        ticketsPage.pushButtonAttachFile(PATH);
        ticketsPage.inputEmail(EMAIL);
        ticketsPage.pushSubmit();

        mainPage.goToLogPage();

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.inputUser(System.getProperty("user"));
        loginPage.inputPassword(System.getProperty("password"));
        loginPage.pushLogin();


        ConfidentialPage confidentialPage = PageFactory.initElements(driver, ConfidentialPage.class);
        confidentialPage.inputTicketsName(SUMMARY_PROBLEM);
        confidentialPage.pushButtonGO();

        AllTickets allTickets = PageFactory.initElements(driver, AllTickets.class);
        allTickets.goToMyTickets();

        MyTickets myTickets = PageFactory.initElements(driver, MyTickets.class);
        String actualTicketsName = myTickets.getTicketsName();
        String actualDescription = myTickets.getDescription();
        driver.close();
        System.out.println(actualDescription);
        System.out.println(actualTicketsName);
        Assert.assertTrue(actualTicketsName.contains(SUMMARY_PROBLEM));
        Assert.assertEquals(actualDescription, YOUR_ISSUE);


    }

}
