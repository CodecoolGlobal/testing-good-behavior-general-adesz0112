package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;


    @Given("user is already logged in {string} with valid {string} and {string} credentials")
    public void user_is_already_logged_in_with_valid_and_credentials(String url, String userName, String password) throws InterruptedException {
        this.driver = Hook.getDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToHomePage(url);
        loginPage.loginProcess(userName, password);
    }

    @When("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        homePage.logout();
    }

    @Then("user is navigated to login page")
    public void user_is_navigated_to_login_page() {
        String actual = driver.getCurrentUrl();
        String expected = "http://localhost:5173/login";
        assertEquals(expected, actual);
    }

}
