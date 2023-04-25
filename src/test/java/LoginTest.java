import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;

    @BeforeMethod
    public void SetUp(){
        driver=openWebDriver();
        loginPage=new LoginPage(driver);
    }
    @Test
    public void TestLoginWithWalidData(){
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
    }
    @Test
    public void TestWithInwalidUsername(){
        loginPage.EnterInwalidUsername();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
    }
    @Test
    public void TestWithInwalidPasword(){
        loginPage.EnterUserName();
        loginPage.EnterInwalidPassword();
        loginPage.ClickLogin();
    }
    @Test
    public void TestWithInwalidUsernameAndInwalidPaswword(){
        loginPage.EnterInwalidUsername();
        loginPage.EnterInwalidPassword();
        loginPage.ClickLogin();
    }
    @Test
    public void TestWithBlanckFieldsUsernameAndPasword(){
        loginPage.EnterBlancUsernameandPasword();
        loginPage.ClickLogin();
    }
    @AfterMethod
    public void AfterTest(){
        driver.quit();
    }
}
