import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegistrationTest extends TestBase{

    RegistrationPage registrationPage;
    @Test
    public void ValidRegister() throws InterruptedException {
        registrationPage =new RegistrationPage(driver);
        registrationPage.OpenRegisterationPage();
        registrationPage.Register("mahmoud","Eid","mahmoud29@gmail.com","123eidEid@","123eidEid@");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[1]/strong")).getText().contains("Account Information"));
        WebElement logout = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
        logout.click();
        WebElement logout2 = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        logout2.click();
        Thread.sleep(3000);
    }

    @Test
    public void InValidRegister1_WeakPassword()//Weak Password
    {
        registrationPage =new RegistrationPage(driver);
        registrationPage.OpenRegisterationPage();
        registrationPage.Register("mahmoud","Eid","mahmoud@gmail.com","123","123");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"password-error\"]")).getText().contains("Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."));


    }
    @Test
    public void InValidRegister2_DifferentPassword()//different password
    {
        registrationPage =new RegistrationPage(driver);
        registrationPage.OpenRegisterationPage();
        registrationPage.Register("mahmoud","Eid","mahmoud@gmail.com","123eidEid@","123eidEid");
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"password-confirmation-error\"]")).getText().contains("Please enter the same value again."));

    }

}
