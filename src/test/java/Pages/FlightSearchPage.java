package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;
import org.openqa.selenium.interactions.Actions;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class FlightSearchPage {

    static WebDriver driver;
    static ElementHelper elementHelper;
    WebDriverWait wait;

    By takvim=By.xpath("//input[@name='departureDate']");
    By donustakvim=By.xpath("//input[@name='returnDate']");
    By slider=By.xpath("//div[contains(@class,'search__filter_departure')]//div[4]");
    By gidiskalkisSaatleri=By.xpath("//div[contains(@class,'ctx-filter-departure-return-time card-header')]//span[contains(@class,'card-title')]");
    By slidervaris=By.xpath("//div[contains(@class,'search__filter_arrival')]//div[5]");
    By yolcusayisibutonu=By.xpath("//div[@data-testid='enuygun-homepage-flight-selectPassengerAndCabin']//div[@shape='flat']//div[1]");
    By yetiskinarttirmabutonu=By.xpath("//button[@data-testid='flight-adult-counter-plus-button']");
    By cocukarttirmabutonu=By.xpath("//button[@data-testid='flight-child-counter-plus-button']");
    By bebekarttirmabutonu=By.xpath("//button[@data-testid='flight-infant-counter-plus-button']");
    By tamambutonu=By.xpath("//span[normalize-space()='Tamam']");
    By havayollarısecenegi=By.xpath("//div[@class='ctx-filter-airline card-header']//span[@class='card-title']");
    By ilksecbutonu=By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/button[1]");
    By secVeİlerle=By.xpath("//span[contains(text(),'Seç ve İlerle')]");
    By thy=By.xpath("//label[@for='TKairlines']");
    By donussecButonu=By.xpath("//div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/button[1]/span[1]");
    By ilkpaket=By.xpath("/html[1]/body[1]/div[3]/div[4]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[6]/div[1]/div[1]");
    By iletisimBilgileri=By.xpath("//div[contains(text(),'İletişim Bilgileri')]");
    By epostaadresi=By.xpath("//input[@name='contactEmail']");
    By contactTelefonNo=By.xpath("//input[@name='contactMobile']");
    By rizaMetniCheckBox=By.xpath("//label[@for='acceptEmails']//span[@class='custom-control-indicator']");
    By yetiskin=By.xpath("//span[@class='passenger-translate']");
    By ad=By.xpath("(//input[@name='firstName_0'])[1]");
    By soyad=By.xpath("//input[@id='lastName_0']");
    By id=By.xpath("//input[@id='_0']");
    By cinsiyet=By.xpath("//label[normalize-space()='Erkek']");
    By epostaErrorMsg=By.xpath("(//div[@class='input-notice text-danger'])[1]");
    By cepTelError=By.xpath("(//span[normalize-space()='Lütfen geçerli bir cep telefonu girin'])[1]");
    By aderror=By.xpath("(//span[@class='label-error-message'][contains(text(),'Lütfen isim ve soyisim bilgilerinizi kimlik ya da ')])[1]");
    By idError=By.xpath("//span[contains(text(),'Lütfen yolcuya ait TC Kimlik Numarasını girin.')]");
    By dtError=By.xpath("(//span[contains(text(),'Lütfen geçerli bir doğum tarihi girin.')])[1]");

    public FlightSearchPage(WebDriver driver){
        this.driver = driver;
        this.wait= new WebDriverWait(driver,10);
        this.elementHelper= new ElementHelper(driver);
    }

    public void gidistarihsecimi(String hedefTarih) {
        elementHelper.findElement(takvim);
        elementHelper.click(takvim);
        try {
            Thread.sleep(2000);
            System.out.println("2 Saniye Bekliyoruz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DateTimeFormatter formatlayici = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tarih = LocalDate.parse(hedefTarih, formatlayici);
        String ayString = String.format("%02d", tarih.getMonthValue());
        String gunString = String.format("%02d", tarih.getDayOfMonth());
        String xpathExpression = "//button[substring(@title, string-length(@title) - 4) = '" + ayString + "-" + gunString + "']";
        WebElement istedigimizGunButonu = null;
        while (istedigimizGunButonu == null || !istedigimizGunButonu.isDisplayed()) {
            try {

                istedigimizGunButonu = driver.findElement(By.xpath(xpathExpression));
                if (istedigimizGunButonu.isDisplayed()) {
                    System.out.println("Buton bulundu: " + istedigimizGunButonu.getAttribute("title"));
                    istedigimizGunButonu.click();
                    try {
                        Thread.sleep(2000);
                        System.out.println("5 Saniye Bekliyoruz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {

                System.out.println("Buton görünür değil, bir sonraki aya geçiliyor...");
                WebElement sonrakiAyButonu = driver.findElement(By.xpath("//button[@data-testid='enuygun-homepage-flight-departureDate-month-forward-button']"));
                sonrakiAyButonu.click();
                try {
                    Thread.sleep(1000); // Sonraki aya geçtikten sonra ek 1 saniye bekleme
                    System.out.println("Sonraki aya geçişten sonra 1 saniye bekliyoruz");
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
    public void donustarihsecimi(String donusgun) {
        elementHelper.click(donustakvim);
        DateTimeFormatter formatlayici = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate tarih = LocalDate.parse(donusgun, formatlayici);
        String ayString = String.format("%02d", tarih.getMonthValue());
        String gunString = String.format("%02d", tarih.getDayOfMonth());
        String xpathExpression = "//button[substring(@title, string-length(@title) - 4) = '" + ayString + "-" + gunString + "']";
        WebElement istedigimizGunButonu = null;
        while (istedigimizGunButonu == null || !istedigimizGunButonu.isDisplayed()) {
            try {

                istedigimizGunButonu = driver.findElement(By.xpath(xpathExpression));
                if (istedigimizGunButonu.isDisplayed()) {
                    System.out.println("Buton bulundu: " + istedigimizGunButonu.getAttribute("title"));
                    istedigimizGunButonu.click();
                    try {
                        Thread.sleep(1000);
                        System.out.println("1 Saniye Bekliyoruz");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            } catch (org.openqa.selenium.NoSuchElementException e) {
                System.out.println("Buton görünür değil, bir sonraki aya geçiliyor...");
                try {
                    Thread.sleep(200);
                    System.out.println("0.2 Saniye Bekliyoruz");
                } catch (InterruptedException x) {
                    x.printStackTrace();
                }
                WebElement sonrakiAyButonu = driver.findElement(By.xpath("//button[@data-testid='enuygun-homepage-flight-returnDate-month-forward-button']"));
                sonrakiAyButonu.click();
            }
            try {
                Thread.sleep(200);
                System.out.println("0.2 Saniye Bekliyoruz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(200);
                System.out.println("0.2 Saniye Bekliyoruz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gidiskalkisvarissaatidüzeltme() {
        elementHelper.click(gidiskalkisSaatleri);
        elementHelper.findElement(slider);
        elementHelper.findElement(slidervaris);
        WebElement timeDisplay = driver.findElement(By.xpath("//div[contains(text(),'00:00 ile 23:59 arası')]"));
        WebElement slider = driver.findElement(By.xpath("//div[contains(@class,'search__filter_departure')]//div[4]")); // Soldaki Varış
        WebElement slider2= driver.findElement(By.xpath("//div[contains(@class,'search__filter_departure')]//div[5]")); // Sağdaki Varış
        Actions actions = new Actions(driver);

        while (!timeDisplay.getText().contains("10:00")) {
            actions.clickAndHold(slider).moveByOffset(5, 0).release().perform();
            try {
                Thread.sleep(200);
                System.out.println("0.2 Saniye Bekliyoruz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        while (!timeDisplay.getText().contains("18:00")) {
            actions.clickAndHold(slider2).moveByOffset(-10, 0).release().perform();
            try {
                Thread.sleep(200);
                System.out.println("0.2 Saniye Bekliyoruz");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(5000);
            System.out.println("5 Saniye Bekliyoruz");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public boolean ucusListesiKontrol() {
        List<WebElement> kalkisSaatleri = driver.findElements(By.className("flight-departure-time"));
        LocalTime startTime = LocalTime.parse("10:00", DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime endTime = LocalTime.parse("18:00", DateTimeFormatter.ofPattern("HH:mm"));
        boolean tumUcuslarDogru = true;
        for (int i = 0; i < kalkisSaatleri.size(); i++) {
            WebElement saatElementi = kalkisSaatleri.get(i);
            String saatMetni = saatElementi.getText().trim();
            LocalTime kalkisSaati = LocalTime.parse(saatMetni, DateTimeFormatter.ofPattern("HH:mm"));
            if (kalkisSaati.isBefore(startTime) || kalkisSaati.isAfter(endTime)) {
                System.out.println("Uçuş " + (i + 1) + " yanlış: Kalkış saati (" + saatMetni + ") belirtilen aralıkta değil.");
                tumUcuslarDogru = false;
            } else {
                System.out.println("Uçuş " + (i + 1) + " doğru: Kalkış saati (" + saatMetni + ") belirtilen aralıkta.");
            }
        }
        return tumUcuslarDogru;
    }

    public void yolcusayisiveucaksecimi(int yetiskinsayisi, int cocuksayisi, int bebeksayisi, String ucaktipi) {
        elementHelper.click(yolcusayisibutonu);
        for (int i = 1; i < yetiskinsayisi; i++) {
            elementHelper.click(yetiskinarttirmabutonu);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Şu anki Yetişkin Sayımız girilen Yetişkin sayısı ile aynı değil, arttırılıyor....");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < cocuksayisi; i++) {
            elementHelper.click(cocukarttirmabutonu);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Şu anki Çocuk Sayımız girilen Çocuk sayısı ile aynı değil, arttırılıyor....");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bebeksayisi; i++) {
            elementHelper.click(bebekarttirmabutonu);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Şu anki Bebek Sayımız girilen Bebek sayısı ile aynı değil, arttırılıyor....");
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
WebElement ucaktipibutonu=driver.findElement(By.xpath("//span[normalize-space()='"+ucaktipi+"']"));
        ucaktipibutonu.click();
        elementHelper.click(tamambutonu);
    }
    public void listelenenucusfiyatkontrolü() {
        List<WebElement> fiyatElementleri = driver.findElements(By.className("money-decimal"));
        double oncekiFiyat = Double.MIN_VALUE;
        for (WebElement fiyatElementi : fiyatElementleri) {
            String fiyatMetni = fiyatElementi.getText().trim();
            if (!fiyatMetni.isEmpty()) {
                double mevcutFiyat = Double.parseDouble(fiyatMetni);
                Assert.assertTrue(mevcutFiyat >= oncekiFiyat, "Fiyatlar küçükten büyüğe sıralı değil!");
                System.out.println("Mevcut Fiyat");
                System.out.println(mevcutFiyat);
                System.out.println(" Önceki Fiyat");
                System.out.println(oncekiFiyat);
                oncekiFiyat = mevcutFiyat;
            }
            else {
                System.out.println("Fiyatlar büyükten küçüğe sıralı");
            }
        }
    }
    public void havayolusirketisecimi() {
        elementHelper.findElement(havayollarısecenegi);
        try {
            Thread.sleep(200);
            System.out.println("Havayolları secenegi bulundu");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.click(havayollarısecenegi);
        try {
            Thread.sleep(200);
            System.out.println("Havayolları seçenegine tiklandi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.findElement(thy);
        try {
            Thread.sleep(200);
            System.out.println("THY bulundu");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.click(thy);
        try {
            Thread.sleep(200);
            System.out.println("THY tiklandı");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enYukaridakiBiletSecilir() {
        elementHelper.click(ilksecbutonu);
        try {
            Thread.sleep(500);
            System.out.println("En yukaridaki Bilet Secildi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        elementHelper.click(secVeİlerle);
        try {
            Thread.sleep(500);
            System.out.println("Secenege Dokunulmadı Direkt Sec ve İlerle Dendi");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void donusbiletisecilir() {
        elementHelper.click(donussecButonu);
        try {
            Thread.sleep(500);
            System.out.println("Secenege Dokunulmadı Direkt Sec ve İlerle Dendi");
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        elementHelper.click(ilkpaket);
    }

    public void formdoldur() {
        elementHelper.findElement(iletisimBilgileri);
        System.out.println("1");
        elementHelper.click(iletisimBilgileri);
        System.out.println("2");
        elementHelper.findElement(epostaadresi);
        System.out.println("3");
        elementHelper.findElement(epostaadresi).sendKeys("fatihtest%%");
        System.out.println("4");
        elementHelper.findElement(id).sendKeys("888888888888");
        System.out.println("5");
        elementHelper.click(yetiskin);
        System.out.println("6");
        elementHelper.findElement(ad).sendKeys("%%%%%%%%%");
        System.out.println("7");
        elementHelper.click(yetiskin);
        elementHelper.findElement(soyad).sendKeys("%%%%%%%%%");
        elementHelper.click(yetiskin);
        WebElement gunselect=driver.findElement(By.xpath("//select[@id='birthDateDay_0']"));
        Select gunselectAlanı= new Select(gunselect);
        gunselectAlanı.selectByValue("31");
        System.out.println("Gün Girildi");
        WebElement ayselect=driver.findElement(By.xpath("//select[@name='birthDateMonth_0']"));
        Select ayAlanı= new Select(ayselect);
        ayAlanı.selectByValue("02");
        System.out.println("Ay Girildi");
        WebElement yilselect=driver.findElement(By.xpath("(//select[@name='birthDateYear_0'])"));
        Select yilAlanı= new Select(yilselect);
        yilAlanı.selectByValue("1999");
        elementHelper.findElement(id).sendKeys("888888888888");

    }

    public void hatamesajlaribul() {
        elementHelper.findElement(epostaErrorMsg);
        elementHelper.checkVisible(epostaErrorMsg);
        elementHelper.findElement(aderror);
        elementHelper.checkVisible(aderror);
        elementHelper.findElement(idError);
        elementHelper.checkVisible(idError);
        elementHelper.findElement(dtError);
        elementHelper.checkVisible(dtError);
    }
}


