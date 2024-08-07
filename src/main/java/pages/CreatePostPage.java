package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CreatePostPage extends BasePage{

    String filePath = System.getenv("IMAGE_LOCAL_PATH");
    private final int SECONDS_OF_SLEEP = 3000;

    @FindBy(className = "select-from-computer-button")
    private WebElement uploadBtn;
    @FindBy(className = "textAreaInput")
    private WebElement textAreaInput;
    @FindBy(id = "formBtn")
    private WebElement formBtn;
    @FindBy(id = "newPost")
    private WebElement newPostBtn;

    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    public void clicksOnCreateNewPostBtn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(newPostBtn)).click();
    }
    public void uploadImageFile() {
        sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(uploadBtn)).sendKeys(filePath);
    }

    public void writeDescription(){
        String testDescription = "Test";
        wait.until(ExpectedConditions.visibilityOf(textAreaInput)).sendKeys(testDescription);
    }

    public void clickOnCreatePostBtn(){
        wait.until(ExpectedConditions.visibilityOf(formBtn)).click();
    }
}
