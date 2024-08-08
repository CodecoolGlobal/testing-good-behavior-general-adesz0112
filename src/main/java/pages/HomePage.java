package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {

    private final int SECONDS_OF_SLEEP = 2000;
    @FindBy(xpath = "//img[@alt='moon']")
    private WebElement darkButton;
    @FindBy(xpath = "//img[@alt='sun']")
    private WebElement dayButton;
    @FindBy(id = "logoutbtn")
    private WebElement logoutButton;
    @FindBy(id = "light")
    private WebElement lightElement;
    @FindBy(id = "dark")
    private WebElement darkElement;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
        sleep(SECONDS_OF_SLEEP);
    }

    public void logout() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }

    public void clickNightModeButton() {
        sleep(SECONDS_OF_SLEEP);
        darkButton.click();
    }

    public void clickDayButton() {
        sleep(SECONDS_OF_SLEEP);
        dayButton.click();
    }

    public String getNightModeBackGroundColor() {
        sleep(1000);
        String bgColor = darkElement.getCssValue("background-color");
        return Color.fromString(bgColor).asHex();
    }

    public String getDayModeBackGroundColor() {
        sleep(1000);
        String bgColor = lightElement.getCssValue("background-color");
        return Color.fromString(bgColor).asHex();
    }

}
