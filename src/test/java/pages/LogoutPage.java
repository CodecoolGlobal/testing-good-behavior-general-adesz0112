package pages;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LogoutPage extends BasePage {

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
    @FindBy(id = "logoutbtn")
    private WebElement logoutButton;

    @Given("user is already logged in {string} with valid {string} and {string} credentials")
    public void user_is_already_logged_in_with_valid_and_credentials(String url, String username, String password) {
        driver.get(url);
        driver.manage().window().maximize();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
        sleep(2000);
    }
    @When("user clicks on the logout button")
    public void user_clicks_on_the_logout_button() {
        logoutButton.click();
    }
    @Then("user is navigated to login page")
    public void user_is_navigated_to_login_page() {
        String actual = driver.getCurrentUrl();
        String expected = "http://localhost:5173/login";
        assertEquals(expected, actual);
    }
}
