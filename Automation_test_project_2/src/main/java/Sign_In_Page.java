import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Sign_In_Page extends PageBase{

    public Sign_In_Page(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[2]/a")
    WebElement SignIn ;
    @FindBy (id = "email")
    WebElement Email ;
    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[3]/div/input")
    WebElement Password ;
    @FindBy (xpath = "/html/body/div[2]/main/div[3]/div/div[2]/div[1]/div[2]/form/fieldset/div[4]/div[1]/button")
    WebElement SignInButton ;
    public void OpenSignInPage ()
    {
        SignIn.click();
    }
    public void SignIn (String e,String p)
    {
        Email.sendKeys(e);
        Password.sendKeys(p);
        SignInButton.click();
    }


}
