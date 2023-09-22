package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static StepDefs.Hooks.driver;

public class Login {
    @Given("user navigate to login page")
    public void NavigateToLogin(){
        driver.navigate().to(Hooks.LoginPage);
    }


    @Given("user fill invalid email and invalid password")
    public void FillData(){
        driver.findElement(By.xpath("//input[@id=\"ctl00_CPHContainer_txtUserLogin\"]")).sendKeys(Hooks.email);
        driver.findElement(By.xpath("//input[@id=\"ctl00_CPHContainer_txtPassword\"]")).sendKeys(Hooks.password);
    }
    @And("user press login")
    public void PressLogin(){
        driver.findElement(By.xpath("//input[@id=\"ctl00_CPHContainer_btnLoginn\"]")).click();
    }

    @Then("Error message displayed")
    public void VerifyError(){
        String ac=new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"ctl00_CPHContainer_lblOutput\"]"))).getText();
        String ex= "User Id or Password did Not Match!!";
        Assert.assertEquals(ex,ac);
    }



}
