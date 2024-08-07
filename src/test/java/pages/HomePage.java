package pages;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy( id="username")
    private WebElement usernameField;
    @FindBy( id = "password")
    private WebElement passwordField;
    @FindBy( xpath = "//*[@id=\"root\"]/div/div/div/form/button[1]")
    private WebElement loginButton;
    @FindBy ( xpath = "//*[@id=\"dark\"]/button/img")
    private WebElement darkAndLightButton;
    @FindBy(id = "logoutbtn")
    private WebElement logoutButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }


    public void navigateToHomePage() {
        driver.get("http://localhost:5173/login");
    }

    public void logout() {
        logoutButton.click();
    }


    public void clickDarkButton() {
        darkAndLightButton.click();
    }

}
