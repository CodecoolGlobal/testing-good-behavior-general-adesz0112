package StepDefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CreatePostPage;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class NightModeSteps {

    private LoginPage loginPage;
    private HomePage homePage;
    private WebDriver driver;
    private String backgroundColor;

    public NightModeSteps() {
        this.driver = Hook.getDriver();
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }



    @Given("the page is in night mode")
    public void the_page_is_in_night_mode() {
        homePage.clickNightModeButton();
    }

    @When("user clicks on the night mode button")
    public void user_clicks_on_the_night_mode_button() {
        backgroundColor = homePage.getDayModeBackGroundColor();
        homePage.clickNightModeButton();
    }

    @When("user clicks on the day mode button")
    public void user_clicks_on_the_day_mode_button() {
        backgroundColor = homePage.getNightModeBackGroundColor();
        homePage.clickDayButton();
    }

    @Then("the background color of the page is changed")
    public void the_background_color_of_the_page_is_changed() {
        String actualBackgroundColor = homePage.getNightModeBackGroundColor();
        assertNotEquals(backgroundColor, actualBackgroundColor);
    }

    @Then("the background color of the page is changed to light mode")
    public void the_background_color_of_the_page_is_changed_to_light_mode() {
        String actualBackgroundColor = homePage.getDayModeBackGroundColor();
        assertNotEquals(backgroundColor, actualBackgroundColor);
    }
}
