package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatePostPage extends BasePage {

    String filePath = System.getenv("IMAGE_LOCAL_PATH");
    private final int SECONDS_OF_SLEEP = 3000;

    @FindBy(className = "select-from-computer-button")
    private WebElement uploadBtn;
    @FindBy(id = "description")
    private WebElement textAreaInput;
    @FindBy(id = "formBtn")
    private WebElement formBtn;
    @FindBy(id = "newPost")
    private WebElement newPostBtn;
    @FindBy(className = "images")
    private WebElement uploadedImage;

    public CreatePostPage(WebDriver driver) {
        super(driver);
    }

    public void clicksOnCreateNewPostBtn() {
        wait(newPostBtn);
        newPostBtn.click();
    }

    public void uploadImageFile() {
        sleep(SECONDS_OF_SLEEP);
        wait(uploadBtn).click();
        uploadBtn.sendKeys(filePath);
    }

    public void writeDescription() {
        String testDescription = "Test";
        wait(textAreaInput).sendKeys(testDescription);
    }

    public void clickOnCreatePostBtn() {
        wait.until(ExpectedConditions.visibilityOf(formBtn)).click();
    }

    public WebElement getUploadedImage() {
        return uploadedImage;
    }
}
