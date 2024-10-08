package StepDefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.RegistrationPage;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RegistrationSteps {

    private HomePage homePage;
    private RegistrationPage registrationPage;
    private WebDriver driver;

    public RegistrationSteps() {
        this.driver = Hook.getDriver();
        this.homePage = new HomePage(driver);
        this.registrationPage = new RegistrationPage(driver);
    }

    @When("user enters {string}, {string} and valid {string}, {string} and {string} credentials")
    public void userEntersValidCredentials(String firstName, String lastName, String userName, String email, String password) {
        registrationPage.registerProcess(firstName,lastName,userName,email,password);
    }

    @When("user clicks on the Create an account button")
    public void userClicksOnTheRegisterBtn() throws InterruptedException {
        registrationPage.clickRegisterBtn();
    }

    @When("user resizes the window to {string}")
    public void resizeWindow(String dimension) {
        String[] dimensions = dimension.split("x");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);
        registrationPage.resizeWindow(width,height);
    }

    @Then("user should be on the {string} page")
    public void userShouldBeOnTheLoginPage(String loginPageUrl) {
        String actualPageUrl = registrationPage.getCurrUrl();
        assertEquals(loginPageUrl, actualPageUrl);
    }

    @Then("user should not be be on the {string} page")
    public void userShouldNotBeOnTheLoginPage(String loginPageUrl) {
        String actualPageUrl = registrationPage.getCurrUrl();
        assertNotEquals(loginPageUrl, actualPageUrl);
    }

    @Then("The registration should fail or show an error message")
    public void verifySQLInjection() {
        String pageSource = registrationPage.getPageSource();
        System.out.println(pageSource);
        assertTrue(pageSource.contains("error") || pageSource.contains("Registration failed"));
    }

    @Then("an error message should indicate the password is too short")
    public void verifyPasswordTooShort() {
        String pageSource = registrationPage.getPageSource();;
        assertTrue(pageSource.contains("Password is too short"));
    }

    @Then("layout should adjust correctly")
    public void verifyResizesUIRegistrationPage() {
        assertTrue(registrationPage.signUpFormIsDisplayed());
    }
}
