package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps extends DriverManager{
    private LoginPage loginPage;
    private HomePage homePage;

    @After
    public void terminateDriver(){
        teardown();
    }

    @Given("user is on the {string} login page")
    public void user_is_on_the_login_page(String regPageUrl) {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToHomePage(regPageUrl);
    }
    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String userName, String password) {
       loginPage.enterUserNameAndPassword(userName, password);
    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginPage.login();
    }


    @Then("user is on the home page")
    public void user_is_on_the_home_page() {
        String actual = driver.getCurrentUrl();
        String expected = "http://localhost:5173/";
        assertEquals(expected, actual);
    }

    @Then("user is on the login page")
    public void user_is_on_the_login_page() {
        String actual = driver.getCurrentUrl();
        String expected = "http://localhost:5173/login";
        assertEquals(expected, actual);
    }
}
