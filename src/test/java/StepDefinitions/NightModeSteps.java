package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;
import pages.LoginPage;

public class NightModeSteps {

    /*private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;


    @Given("user is on the {string} page with valid {string} and {string} credentials")
    public void user_is_on_the_page_with_valid_and_credentials(String url, String userName, String password) {
        driver = new EdgeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToHomePage();
        driver.manage().window().maximize();
        loginPage.enterUserNameAndPassword(userName, password);
        loginPage.login();
    }
    @Given("the page is in night mode")
    public void the_page_is_in_night_mode() {
        homePage.navigateToHomePage();
    }
    @When("user clicks on the day mode button")
    public void user_clicks_on_the_day_mode_button() {
        homePage.clickDarkButton();
    }
    @Then("the background color of the page is changed")
    public void the_background_color_of_the_page_is_changed() {

    }*/
}
