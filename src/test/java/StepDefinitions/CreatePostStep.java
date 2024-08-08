package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.CreatePostPage;
import pages.HomePage;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CreatePostStep {

    private WebDriver driver;
    private CreatePostPage createPostPage;
    private HomePage homePage;
    private LoginPage loginPage;


    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("user is on the {string} login page to login before")
    public void userLogsIn(String loginPageUrl) {
        driver = new EdgeDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        createPostPage = new CreatePostPage(driver);
        driver.manage().window().maximize();
        homePage.navigateToHomePage(loginPageUrl);
    }

    @When("user enters {string} and {string} credentials")
    public void userEntersCredentials(String username, String password) {
        loginPage.enterUserNameAndPassword(username, password);
    }

    @When("user clicks on the login button to login")
    public void userClickOnLoginBtn() {
        loginPage.login();
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

    @Given("user sees the uploaded image")
    public void userSeesUploadedImage(){
        assertTrue(createPostPage.getUploadedImage().isDisplayed());
    }
}
