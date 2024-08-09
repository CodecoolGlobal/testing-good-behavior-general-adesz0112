package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

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
        wait(signUpForm);
    }

    public void clickRegisterBtn() {
        wait(registerBtn).click();
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

    public void registerProcess(String firstName, String lastName, String userName, String email, String password){
        clickToSignUp();
        enterFirstName(firstName);
        enterLastName(lastName);
        enterUsername(userName);
        enterEmail(email);
        enterPassword(password);
    }

    public boolean signUpFormIsDisplayed() {
        return signUpForm.isDisplayed();
    }

    public void resizeWindow(int width, int height){
        driver.manage().window().setSize(new Dimension(width, height));
    }
    public String getCurrUrl() {
        return driver.getCurrentUrl();
    }

    public String getPageSource(){
       return driver.getPageSource();
    }
}


