import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(id = "user-name")
    WebElement UserName;

    @FindBy(id = "password")
    WebElement Password;

    @FindBy(id = "login-button")
    WebElement LoginButton;


    @FindBy(css = ".shopping_cart_link")
    WebElement Cart;
    @FindBy(css = "h3[data-test='error']")
    WebElement Eror1;


    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void EnterUserName() {
        UserName.sendKeys("standard_user");
    }

    public void EnterPassword() {
        Password.sendKeys("secret_sauce");
    }

    public void ClickLogin() {
        LoginButton.submit();
    }

    public void EnterInwalidUsername() {
        UserName.sendKeys("Dejan");
    }


    public void EnterInwalidPassword() {
        Password.sendKeys("123456789456");
    }
    public void EnterBlancUsernameandPasword(){
        UserName.sendKeys("");
        Password.sendKeys("");
    }
    public String ErorMessage1(){
        return Eror1.getText();
    }

}
