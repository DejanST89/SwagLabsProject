import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;
    @BeforeMethod
    public void SetUp() {
        driver = openWebDriver();
        loginPage = new LoginPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }
    @Test
    public void ClickonCartTest(){
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
        productPage.AddBackPack();
        productPage.AddTShirt();
        Assert.assertEquals(cartPage.CartVerivifaciton(), "2");
        cartPage.ClickOnCart();
        cartPage.ClickOnCheckout();
        cartPage.EnterPersonalData();
        cartPage.ClickOnFinish();
        Assert.assertEquals(cartPage.Massage(), "Thank you for your order!");

    }
    @AfterMethod
    public void After(){
        driver.quit();
    }
}
