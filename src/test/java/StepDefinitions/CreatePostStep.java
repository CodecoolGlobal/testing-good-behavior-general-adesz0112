package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import pages.CreatePostPage;
import pages.HomePage;
import pages.LoginPage;

public class CreatePostStep extends DriverManager {

    private CreatePostPage createPostPage;
    private HomePage homePage;
    private LoginPage loginPage;

    @Before
    public void setup() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        createPostPage = new CreatePostPage(driver);
    }

    @After
    public void terminateDriver(){
        teardown();
    }

    @Given("user is on the {string} login page to login before")
    public void userLogsIn(String loginPageUrl) throws InterruptedException {
        homePage.navigateToHomePage(loginPageUrl);
        Thread.sleep(5000);
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
}
