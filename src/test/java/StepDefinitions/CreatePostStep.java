package StepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.CreatePostPage;

public class CreatePostStep {


    private CreatePostPage createPostPage;


    @When("user clicks on the Create Post button on the home page")
    public void userClicksOnCreateNewPostBtnOnHomePage() throws InterruptedException {
        Thread.sleep(3000);
        createPostPage.clicksOnCreateNewPostBtn();
    }

    @When("user uploads an image file")
    public void userUploadsAnImageFile() {
        createPostPage.uploadImageFile();
    }

    @When("user writes description")
    public void userWritesDescription() {
        createPostPage.writeDescription();
    }

    @When("user clicks on the Create Post button")
    public void userClicksOnCreatePostBtn() {
        createPostPage.clickOnCreatePostBtn();
    }

}
