package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;
import pages.LoginPage;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class NightModeSteps {

    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;
    private String backgroundColor;


    @Given("user is on the {string} page with valid {string} and {string} credentials")
    public void user_is_on_the_page_with_valid_and_credentials(String url, String userName, String password) {
        driver = new EdgeDriver();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        homePage.navigateToHomePage(url);
        driver.manage().window().maximize();
        loginPage.enterUserNameAndPassword(userName, password);
        loginPage.login();
    }
    @Given("the page is in night mode")
    public void the_page_is_in_night_mode() throws InterruptedException {
        sleep(2000);
        homePage.clickNightModeButton();
    }

    @When("user clicks on the night mode button")
    public void user_clicks_on_the_night_mode_button() throws InterruptedException {
        sleep(2000);
        backgroundColor = homePage.getDayModeBackGroundColor();
        homePage.clickNightModeButton();
    }

    @When("user clicks on the day mode button")
    public void user_clicks_on_the_day_mode_button() throws InterruptedException {
        sleep(2000);
        backgroundColor = homePage.getNightModeBackGroundColor();
        homePage.clickDayButton();
    }
    @Then("the background color of the page is changed")
    public void the_background_color_of_the_page_is_changed() {
        String actualBackgroundColor = homePage.getNightModeBackGroundColor();
        assertNotEquals(backgroundColor,actualBackgroundColor);
    }

    @Then("the background color of the page is changed to light mode")
    public void the_background_color_of_the_page_is_changed_to_light_mode() {
        String actualBackgroundColor = homePage.getDayModeBackGroundColor();
        assertNotEquals(backgroundColor,actualBackgroundColor);
    }
}
