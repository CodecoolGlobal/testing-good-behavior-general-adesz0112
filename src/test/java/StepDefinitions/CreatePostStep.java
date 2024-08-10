package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.CreatePostPage;
import pages.HomePage;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePostStep {

    private WebDriver driver;
    private CreatePostPage createPostPage;
    private HomePage homePage;
    private LoginPage loginPage;

    public CreatePostStep() {
        this.driver = Hook.getDriver();
        this.createPostPage = new CreatePostPage(driver);
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
    }


    @When("user clicks on the Create Post button on the home page")
    public void userClicksOnCreateNewPostBtnOnHomePage() {
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

    @Then("user sees the uploaded image")
    public void userSeesUploadedImage() {
        assertTrue(createPostPage.getUploadedImage().isDisplayed());
    }
}
