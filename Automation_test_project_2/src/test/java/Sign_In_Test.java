import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Sign_In_Test extends TestBase{
    Sign_In_Page SignInPage ;
    String ValidEmail="mahmoud29@gmail.com";
    String InValidEmail="ahmoud19@gmail.com";
    String ValidPassword="123eidEid@";
    String InValidPassword="23eidEid@";
    @Test(priority = 1)
    public void ValidSignIn() throws InterruptedException {
        SignInPage=new Sign_In_Page(driver);
        SignInPage.OpenSignInPage();
        SignInPage.SignIn(ValidEmail,ValidPassword);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText().contains("Welcome, mahmoud Eid!"));
        WebElement logout = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/span/button"));
         logout.click();
        WebElement logout2 = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/div/ul/li[3]/a"));
        logout2.click();
         //Select DropDown = new Select(logout);
         //  DropDown.selectByIndex(3);


    }
    @Test(priority = 3)
    public void InValidUserName() throws InterruptedException {
        SignInPage=new Sign_In_Page(driver);
        SignInPage.OpenSignInPage();
        SignInPage.SignIn(InValidEmail,ValidPassword);
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText().contains("Incorrect CAPTCHA"));
        driver.quit();
    }
    @Test(priority = 2)
    public void InValidPassword() throws InterruptedException {
        SignInPage=new Sign_In_Page(driver);
        SignInPage.OpenSignInPage();
        SignInPage.SignIn(ValidEmail,InValidPassword);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText().contains("The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."));
    }


    /*@Test(priority = 4)
    public void InValidUserName_Password() throws InterruptedException {
        SignInPage=new Sign_In_Page(driver);
        SignInPage.OpenSignInPage();
        SignInPage.SignIn(InValidEmail,InValidPassword);
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")).getText().contains("Incorrect CAPTCHA"));

    }*/
}
