import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseTest{
    ChromeDriver driver;
    LoginPage loginPage;
    ProductPage productPage;
    SortPage sortPage;

    CartPage cartPage;


    @BeforeMethod
    public void SetUp(){
        driver=openWebDriver();
        loginPage=new LoginPage(driver);
        productPage= new ProductPage(driver);
        cartPage=new CartPage(driver);
        sortPage= new SortPage(driver);
    }
    @Test
    public void AddProductsToCart(){
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
        productPage.AddBackPack();
        productPage.AddTShirt();
        cartPage.ClickOnCart();
        productPage.RemoveTshirt();
        productPage.RemoveBackPack();
        productPage.BacktoHomePage();
        Assert.assertEquals(cartPage.CartVerivifaciton(), "");



    }
    @Test
    public void LowPriceTest(){
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
        sortPage.SortItemByText("Price (low to high)");
        Assert.assertEquals(sortPage.Price(),"$7.99");
        productPage.AddOnesie();
        productPage.AddBikeLight();
        productPage.AddTShirt();
        Assert.assertEquals(cartPage.CartVerivifaciton(), "3");

    }
    @Test
    public void TotalPriceTest(){
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
        productPage.AddTShirt();
        productPage.AddBikeLight();
        cartPage.ClickOnCart();
        cartPage.ClickOnCheckout();
        cartPage.EnterPersonalData();
        Assert.assertEquals(cartPage.TotalPrice(),"Total: $28.06");


    }
    @Test
    public void ItemTotalTest(){
        loginPage.EnterUserName();
        loginPage.EnterPassword();
        loginPage.ClickLogin();
        productPage.AddTShirt();
        productPage.AddBikeLight();
        cartPage.ClickOnCart();
        cartPage.ClickOnCheckout();
        cartPage.EnterPersonalData();
        Assert.assertEquals(cartPage.ItemTotal(),"Item total: $25.98");


    }
    @AfterMethod
    public void After(){
        driver.quit();}
}
