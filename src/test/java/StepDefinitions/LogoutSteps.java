package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutSteps {

    private HomePage homePage;
    private LoginPage loginPage;
    private WebDriver driver;

    public LogoutSteps() {
        this.driver = Hook.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
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
