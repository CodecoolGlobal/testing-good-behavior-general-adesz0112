package pages;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreatePostPage extends BasePage{

    private final int SECONDS_OF_SLEEP = 3000;
    String filePath = System.getenv("IMAGE_LOCAL_PATH");

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

    @When("user clicks on the Create Post button on the home page")
    public void userClicksOnCreateNewPostBtnOnHomePage(){
        sleep(3000);
        wait.until(ExpectedConditions.visibilityOf(newPostBtn)).click();
    }

    @When("user uploads an image file")
    public void userUploadsAnImageFile() {
        wait.until(ExpectedConditions.visibilityOf(uploadBtn)).sendKeys(filePath);
    }

    @When("user writes description")
    public void userWritesDescription(){
        String testDescription = "Test";
        wait.until(ExpectedConditions.visibilityOf(textAreaInput)).sendKeys(testDescription);
    }

    @When("user clicks on the Create Post button")
    public void userClicksOnCreatePostBtn(){
        wait.until(ExpectedConditions.visibilityOf(formBtn)).click();
    }

}
