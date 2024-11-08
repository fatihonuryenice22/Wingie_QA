package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;
public class MainPage {
    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

     By gidisDonusSecenegi=By.xpath("//div[@data-testid='search-round-trip-text']");
     By neredenKismi=By.xpath("//div[contains(text(),'Nereden')]");
     By gidisyeriilkeleman=By.xpath("//ul[1]/div[1]/li[1]/div[1]");
     By varisilkeleman=By.xpath("//span[1]/ul[1]/div[1]/li[1]/div[1]/div[1]/div[1]");
     By cerezleriKabulEt=By.id("onetrust-accept-btn-handler");
     By ucuzBiletBulButton=By.xpath("//div[contains(text(),'Ucuz bilet bul')]");
    public MainPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }
    public void gidisSecenegiSecimi() {
        elementHelper.click(cerezleriKabulEt);
        try {
            Thread.sleep(1000);
            System.out.println("1 Saniye Bekliyoruz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.click(gidisDonusSecenegi);
        try {
            Thread.sleep(1000);
            System.out.println("1 Saniye Bekliyoruz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.click(neredenKismi);
        try {
            Thread.sleep(1000);
            System.out.println("1 Saniye Bekliyoruz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public  void varisIlkElemanSecilir() {
        elementHelper.findElement(varisilkeleman);
        elementHelper.click(varisilkeleman);
    }
    public void ilkElemanSecilir() {
        try {
            Thread.sleep(1000);
            System.out.println("1 Saniye Bekliyoruz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.click(gidisyeriilkeleman);
    }

    public void aramaButonunaTikla() {
        elementHelper.click(ucuzBiletBulButton);

    }
}
