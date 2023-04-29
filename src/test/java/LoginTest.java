import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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
        Assert.assertEquals(loginPage.ErorMessage1(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void TestWithInwalidPasword(){
        loginPage.EnterUserName();
        loginPage.EnterInwalidPassword();
        loginPage.ClickLogin();
        Assert.assertEquals(loginPage.ErorMessage1(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void TestWithInwalidUsernameAndInwalidPaswword(){
        loginPage.EnterInwalidUsername();
        loginPage.EnterInwalidPassword();
        loginPage.ClickLogin();
        Assert.assertEquals(loginPage.ErorMessage1(),"Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void TestWithBlanckFieldsUsernameAndPasword(){
        loginPage.EnterBlancUsernameandPasword();
        loginPage.ClickLogin();
        Assert.assertEquals(loginPage.ErorMessage1(),"Epic sadface: Username is required");

    }
    @AfterMethod
    public void AfterTest(){
        driver.quit();
    }
}
