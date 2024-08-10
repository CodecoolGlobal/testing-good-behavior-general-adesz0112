package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    @FindBy(xpath = "//img[@alt='moon']")
    private WebElement darkButton;
    @FindBy(xpath = "//img[@alt='sun']")
    private WebElement dayButton;
    @FindBy(id = "logoutBtn")
    private WebElement logoutButton;
    @FindBy(id = "light")
    private WebElement lightElement;
    @FindBy(id = "dark")
    private WebElement darkElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToPage(String url) {
        driver.get(url);
    }

    public void logout() {
        wait(logoutButton).click();
    }

    public void clickNightModeButton() {
        darkButton.click();
    }

    public void clickDayButton() {
        dayButton.click();
    }

    public String getNightModeBackGroundColor() {
        String bgColor = darkElement.getCssValue("background-color");
        return Color.fromString(bgColor).asHex();
    }

    public String getDayModeBackGroundColor() {
        String bgColor = lightElement.getCssValue("background-color");
        return Color.fromString(bgColor).asHex();
    }

}
