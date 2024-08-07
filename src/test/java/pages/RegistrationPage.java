package pages;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.junit.jupiter.api.Assertions.*;


public class RegistrationPage extends BasePage {

    private final int SECONDS_OF_SLEEP = 3000;

    @FindBy(id = "firstName")
    private WebElement firstNameInput;
    @FindBy(id = "lastName")
    private WebElement lastNameInput;
    @FindBy(id = "username")
    private WebElement usernameInput;
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(className = "formBtn")
    private WebElement registerBtn;
    @FindBy(className = "signUpForm")
    private WebElement signUpForm;

    @After
   public void teardown() {
        driver.quit();
    }

    @Given("user is on the {string} page")
    public void userIsOnTheRegistrationPage(String regPageUrl) {
        driver.get(regPageUrl);
        driver.manage().window().maximize();
    }

    @When("user enters {string}, {string} and valid {string}, {string} and {string} credentials")
    public void userEntersValidCredentials(String firstName, String lastName, String userName, String email, String password) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    @When("user clicks on the Create an account button")
    public void userClicksOnTheRegisterBtn() {
        wait.until(ExpectedConditions.visibilityOf(registerBtn)).click();
        sleep(SECONDS_OF_SLEEP);
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
        assertTrue(signUpForm.isDisplayed());
    }
}

