package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public abstract class DriverManager {

    protected WebDriver driver;


    public void initialize(){
        this.driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
