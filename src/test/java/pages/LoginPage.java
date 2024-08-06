package pages;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage{

    @After
    void teardown(){
        driver.quit();
    }

    @FindBy( id="username")
    private WebElement usernameField;
    @FindBy( id = "password")
    private WebElement passwordField;
    @FindBy( xpath = "//*[@id=\"root\"]/div/div/div/form/button[1]")
    private WebElement loginButton;

    @Given("user is on the {string} login page")
    public void user_is_on_the_login_page(String regPageUrl) {
        driver.get(regPageUrl);
        driver.manage().window().maximize();
    }
    @When("user enters {string} and {string}")
    public void user_enters_username_and_password(String userName, String password) {
        usernameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }
    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() {
        loginButton.click();
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
