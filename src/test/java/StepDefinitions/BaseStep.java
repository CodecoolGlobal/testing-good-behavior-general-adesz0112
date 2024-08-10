package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class BaseStep {


    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;
    private WebDriverWait wait;
    private final int SECOND_OF_WAIT = 5;

    public BaseStep(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SECOND_OF_WAIT));
    }

    public void userIsOnThePage(String regPageUrl) {
        homePage.navigateToPage(regPageUrl);
    }

    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUserNameAndPassword(username, password);
    }

    public void clickOnLoginBtn() {
        loginPage.clickToLogin();
    }
}
