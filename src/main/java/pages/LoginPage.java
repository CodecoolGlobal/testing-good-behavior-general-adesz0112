package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }


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

    public void login(){
        loginButton.click();
        sleep(5000);
    }

}
