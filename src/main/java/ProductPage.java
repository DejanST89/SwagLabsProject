import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage{
    @FindBy(name = "add-to-cart-sauce-labs-backpack")
    WebElement BackPack;
    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement TShirt;
    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement LabsOnesie;
    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement BikeLight;
    @FindBy(id = "remove-sauce-labs-bolt-t-shirt")
    WebElement RemoveProduct1;
    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement RemoveProduct2;
    @FindBy(css = "#continue-shopping")
    WebElement Continue;
    public ProductPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    public void AddBackPack(){
        BackPack.click();
    }
    public void AddTShirt(){
        TShirt.click();
    }
    public void AddOnesie(){
        LabsOnesie.click();
    }
    public void AddBikeLight(){
        BikeLight.click();
    }
    public void RemoveTshirt(){
        RemoveProduct1.click();
    }
    public void RemoveBackPack(){
        RemoveProduct2.click();
    }
    public void BacktoHomePage(){
        Continue.click();
    }
}
