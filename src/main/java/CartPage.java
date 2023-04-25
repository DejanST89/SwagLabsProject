import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage{
    @FindBy(id = "shopping_cart_container")
    WebElement Cart;
    @FindBy(css = "#checkout")
    WebElement CheckoutButton;
    @FindBy(css = "#first-name")
    WebElement FirstName;
    @FindBy(css = "#last-name")
    WebElement lastName;
    @FindBy(css = "#postal-code")
    WebElement PostalCode;
    @FindBy(css = "#continue")
    WebElement ContinueButton;
    @FindBy(css = "#finish")
    WebElement Finish;
    @FindBy(css = ".summary_info_label.summary_total_label")
    WebElement Total;
    @FindBy(css = ".summary_subtotal_label")
    WebElement ItemTotalPrice;
    @FindBy(css = ".complete-header")
    WebElement FinishMessage;
    public CartPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}
    public void ClickOnCart(){
        Cart.click();
    }
    public void ClickOnCheckout(){
        CheckoutButton.click();
    }
    public void EnterPersonalData(){
        FirstName.sendKeys("Dejan");
        lastName.sendKeys("Stancevic");
        PostalCode.sendKeys("11000");
        ContinueButton.submit();
    }
    public void ClickOnFinish(){
        Finish.click();
    }
    public String CartVerivifaciton(){
        return Cart.getText();

    }
    public String TotalPrice(){
        return Total.getText();
    }
    public String ItemTotal(){
        return ItemTotalPrice.getText();
    }
    public String Massage(){
        return FinishMessage.getText();
    }
}
