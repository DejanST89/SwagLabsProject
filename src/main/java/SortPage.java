import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SortPage extends BasePage{
    @FindBy(className = "product_sort_container")
    WebElement SetDropDown;

    @FindBy(className = "inventory_item_price")
    WebElement LowPrice;

    public SortPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    public void SortItemByText(String text) {
        Select drop = new Select(SetDropDown);
        drop.selectByVisibleText(text);


    }
    public String Price(){
        return LowPrice.getText();
    }
}
