package pages;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;


public class RegistrationPage extends BasePage{

    private final int SECONDS_OF_SLEEP = 2000;

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



    @Given("user is on the {string} page")
    public void userIsOnTheRegistrationPage(String regPageUrl){
        driver.get(regPageUrl);
        driver.manage().window().maximize();
    }

    @When("user enters {string}, {string} and valid {string}, {string} and {string} credentials")
    public void userEntersValidCredentials(String firstName, String lastName, String userName, String email, String password){
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(userName);
        wait.until(ExpectedConditions.visibilityOf(emailInput)).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    @When("user clicks on the Create an account button")
    public void userClicksOnTheRegisterBtn(){
        wait.until(ExpectedConditions.visibilityOf(registerBtn)).click();
        sleep(SECONDS_OF_SLEEP);
    }

    @Then("user should be on the {string} page")
    public void userShouldBeOnTheLoginPage(String loginPageUrl){
        String actualPageUrl = driver.getCurrentUrl();
        assertEquals(loginPageUrl, actualPageUrl);
        driver.quit();
    }

    @Then("user should not be be on the {string} page")
    public void userShouldNotBeOnTheLoginPage(String loginPageUrl){
        String actualPageUrl = driver.getCurrentUrl();
        assertNotEquals(loginPageUrl, actualPageUrl);
        driver.quit();
    }

    @Then("The registration should fail or show an error message")
    public void verifySQLInjection() {
        String pageSource = driver.getPageSource();
        System.out.println(pageSource);
        assertTrue(pageSource.contains("error") || pageSource.contains("Registration failed"));
        driver.quit();
    }
}

