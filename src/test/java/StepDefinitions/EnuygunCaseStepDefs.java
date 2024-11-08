package StepDefinitions;

import Pages.FlightSearchPage;
import Pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import util.DriverFactory;
import static org.testng.Assert.assertTrue;

public class EnuygunCaseStepDefs {

    WebDriver driver= DriverFactory.getDriver();
    MainPage mainPage= new MainPage(driver);
    FlightSearchPage flightSearchPage= new FlightSearchPage(driver);


    @When("Kalkış saati filtresinde kalkış saatleri {string} ile {string} arası seçilir")
    public void kalkışSaatiFiltresindeKalkışSaatleriIleArasıSeçilir(String arg0, String arg1) {
        flightSearchPage.gidiskalkisvarissaatidüzeltme();
    }

    @Then("Tüm uçuşların kalkış saatleri 10:00 ile 18:00 arasında olmalıdır")
    public void tümUçuşlarınKalkışSaatleriIleArasındaOlmalıdır() {
        boolean sonuc = flightSearchPage.ucusListesiKontrol();
        assertTrue(sonuc, "Uçuş saatleri 10:00 ile 18:00 arasında değil!");
    }



    @Given("{string} , {string} Parametreleri ile Arama Yapmaya Başlar")
    public void parametreleriIleAramaYapmayaBaşlar(String kalkis, String varis) {
        mainPage.gidisSecenegiSecimi();
        driver.findElement(By.xpath("//input[@name='origin']")).sendKeys(kalkis);
        mainPage.ilkElemanSecilir();
        driver.findElement(By.xpath("//input[@name='destination']")).sendKeys(varis);
        mainPage.varisIlkElemanSecilir();




    }

    @And("Tarih bilgileri parametre olarak girilir {string} {string}")
    public void tarihBilgileriParametreOlarakGirilir(String hedefgun , String donusgun) {
        flightSearchPage.gidistarihsecimi(hedefgun);
        flightSearchPage.donustarihsecimi(donusgun);

    }

    @When("Arama Butonuna Tıklanır")
    public void aramaButonunaTıklanır() {
    mainPage.aramaButonunaTikla();
    }

    @And("Yolcu bilgileri parametre olarak girilir  {int} {int} {int} {string}")
    public void yolcuBilgileriParametreOlarakGirilir(int yetiskinsayisi, int bebeksayisi, int cocuksayisi, String ucaktipi) {
        flightSearchPage.yolcusayisiveucaksecimi(yetiskinsayisi,bebeksayisi,cocuksayisi,ucaktipi);
    }

    @Then("Fiyatların küçükten büyüğe sıralandığı kontrol edilir")
    public void fiyatlarınKüçüktenBüyüğeSıralandığıKontrolEdilir() {
        flightSearchPage.listelenenucusfiyatkontrolü();
    }

    @When("Havayolu sirketi olarak Türk Hava Yolları seçilir")
    public void havayoluSirketiOlarakTürkHavaYollarıSeçilir() {
        flightSearchPage.havayolusirketisecimi();
    }

    @And("En yukarıdaki bilet seçilir")
    public void enYukarıdakiBiletSeçilir() {
        flightSearchPage.enYukaridakiBiletSecilir();
        
    }

    @And("Dönüş bileti seçilir")
    public void dönüşBiletiSeçilir() {
        flightSearchPage.donusbiletisecilir();
        
    }

    @When("Formlar Validate Edilir")
    public void formlarValidateEdilir() {
        flightSearchPage.formdoldur();
        
    }

    @And("Hata Mesajları Validate Edilir")
    public void hataMesajlarıValidateEdilir() {
        flightSearchPage.hatamesajlaribul();
    }
}
