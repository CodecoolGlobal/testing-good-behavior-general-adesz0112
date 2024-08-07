package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void clickToSignUp() {
        wait.until(ExpectedConditions.visibilityOf(signUpForm));
    }

    public void clickRegisterBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(registerBtn));
    }

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void enterUsername(String username) {
        usernameInput.sendKeys(username);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public boolean signUpFormIsDisplayed() {
        return signUpForm.isDisplayed();
    }

}


