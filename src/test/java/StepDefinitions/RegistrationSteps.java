package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.HomePage;
import pages.RegistrationPage;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegistrationSteps {

    private HomePage homePage;
    private RegistrationPage registrationPage;
    private WebDriver driver;

    @After
    public void teardown() {
        driver.quit();
    }

    @Given("user is on the {string} page")
    public void userIsOnTheRegistrationPage(String regPageUrl) {
        driver = new EdgeDriver();
        homePage = new HomePage(driver);

        homePage.navigateToHomePage();
        driver.manage().window().maximize();
    }

    @When("user enters {string}, {string} and valid {string}, {string} and {string} credentials")
    public void userEntersValidCredentials(String firstName, String lastName, String userName, String email, String password) {
        registrationPage.clickToSignUp();
        registrationPage.enterFirstName(firstName);
        registrationPage.enterLastName(lastName);
        registrationPage.enterUsername(userName);
        registrationPage.enterEmail(userName);
        registrationPage.enterPassword(password);
    }

    @When("user clicks on the Create an account button")
    public void userClicksOnTheRegisterBtn() throws InterruptedException {
        registrationPage.clickRegisterBtn();
        sleep(2000);
    }

    @When("user resizes the window to {string}")
    public void resizeWindow(String dimension) {
        String[] dimensions = dimension.split("x");
        int width = Integer.parseInt(dimensions[0]);
        int height = Integer.parseInt(dimensions[1]);
        driver.manage().window().setSize(new Dimension(width, height));
    }

    @Then("user should be on the {string} page")
    public void userShouldBeOnTheLoginPage(String loginPageUrl) {
        String actualPageUrl = driver.getCurrentUrl();
        assertEquals(loginPageUrl, actualPageUrl);
    }

    @Then("user should not be be on the {string} page")
    public void userShouldNotBeOnTheLoginPage(String loginPageUrl) {
        String actualPageUrl = driver.getCurrentUrl();
        assertNotEquals(loginPageUrl, actualPageUrl);
    }

    @Then("The registration should fail or show an error message")
    public void verifySQLInjection() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        assertTrue(pageSource.contains("error") || pageSource.contains("Registration failed"));
    }

    @Then("an error message should indicate the password is too short")
    public void verifyPasswordTooShort() {
        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Password is too short"));
    }

    @Then("layout should adjust correctly")
    public void verifyResizesUIRegistrationPage(){
        assertTrue(registrationPage.signUpFormIsDisplayed());
    }
}
