import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    @FindBy (xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
    WebElement CreateAnAccount;
    @FindBy (id = "firstname")
    WebElement FirstName;
    @FindBy (id = "lastname")
    WebElement LastName;
    @FindBy (id = "email_address")
    WebElement EmailAddress;
    @FindBy (xpath = "//*[@id=\"password\"]")
    WebElement Password;
    @FindBy (id = "password-confirmation")
    WebElement PasswordConfirmation;
    @FindBy (xpath = "//*[@id=\"form-validate\"]/div/div[1]/button")
    WebElement SubmitButton;
    public void OpenRegisterationPage ()
    {
        CreateAnAccount.click();
    }
    public void Register (String f,String l,String e,String p,String pc )
    {
         FirstName.sendKeys(f);
         LastName.sendKeys(l);
         EmailAddress.sendKeys(e);
         Password.sendKeys(p);
         PasswordConfirmation.sendKeys(pc);
         SubmitButton.click();
    }

}
