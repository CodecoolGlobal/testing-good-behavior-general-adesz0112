package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final int SECONDS_OF_SLEEP = 3000;
    @FindBy( id="username")
    private WebElement usernameField;
    @FindBy( id = "password")
    private WebElement passwordField;
    @FindBy( xpath = "//*[@id=\"root\"]/div/div/div/form/button[1]")
    private WebElement loginButton;


    public void enterUserNameAndPassword(String username, String password){
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickToLogin(){
        loginButton.click();
    }

    public void loginProcess(String username, String password){
        enterUserNameAndPassword(username, password);
        clickToLogin();
    }

}
