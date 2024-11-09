# Wingie QA Test Otomasyon Projesi

Bu proje, [Wingie](https://www.wingie.com/) uygulaması için Cucumber ve TestNG kullanılarak yapılmış bir test otomasyon projesidir. Proje, kullanıcı senaryolarını otomatik olarak test ederek uygulamanın doğru çalıştığından emin olmayı amaçlar.

## Proje Yapısı ve Kullanılan Teknolojiler

- **Cucumber**: Davranış Odaklı Geliştirme (BDD) yaklaşımı ile test senaryolarını kolayca yazmak için kullanıldı.
- **TestNG**: Test süreçlerini yönetmek, testleri gruplandırmak ve raporlamak amacıyla kullanıldı.
- **Java**: Ana programlama dili olarak kullanıldı.
- **Maven**: Proje bağımlılıklarını yönetmek için kullanıldı.

## Özellikler

- **BDD Senaryoları**: Cucumber ile yazılmış Gherkin dilindeki senaryolar.
- **Parametrik Testler**: TestNG ile parametrik testler desteklenir.
- **Raporlama**: TestNG raporlama özellikleri kullanılarak sonuçlar detaylı bir şekilde raporlanır.
- **Kolay Entegrasyon**: Continuous Integration (CI) araçlarına kolayca entegre edilebilir yapı.
---
## Test Senaryoları
- **Arama İşlevselliği**: Farklı parametrelerle uçuş arama işlemini test eden senaryolar
- **Filtreleme ve Sıralama Kontrolü**: Rezervasyon akışının doğruluğunu test eden senaryolar
- **Hata Mesajları Kontrolü**: Olası yanlış input giriminde kullanıcının karşılaşabileceği hatalar
---
## Kurulum ve Başlatma

Projeyi çalıştırmak için aşağıdaki adımları takip edebilirsiniz.

### Gereksinimler

- Java JDK 8 veya üzeri
- Maven 3.6 veya üzeri
- IDE (IntelliJ IDEA, Eclipse vb.)
- Allure CLI

### Adımlar

1. Projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone https://github.com/fatihonuryenice22/Wingie_QA.git
   ```
2. Klonlanan dizine gidin:
   ```bash
   cd <pom.xml yolu >
   ```
3. Gerekli bağımlılıkları yükleyin:
   ```bash
   mvn clean install
   ```

### Testleri Çalıştırma

Testleri çalıştırmak için şu komutu kullanabilirsiniz:

```bash
mvn test
```

Bu komut, tüm Cucumber senaryolarını TestNG ile çalıştıracaktır. Test sonuçları, `target` klasöründe rapor olarak saklanacaktır.

### Test Senaryoları

Tüm senaryolar `src/test/java/features` klasöründe Enuygun.feature dosyasında Gherkin dili ile yazılmıştır. Her senaryo kullanıcı hikayelerini ve uygulamanın doğru çalışmasını doğrulamak için özel olarak tasarlanmıştır.

### Örnek Senaryo

```gherkin
Feature: Wingie Uygulaması Üzerinde Uçuş Arama

  Scenario: xxxxxxxxxxxxx
    Given xxxxxxxxxxx
    When xxxxxxxxx
    And xxxxxxxxxx
    Then xxxxxx
```

## Raporlama
Bu projede test sonuçlarını görselleştirmek ve analiz etmek için **Allure** raporlama aracı kullanılmaktadır. Allure, testlerin durumu, başarı oranları, hatalar ve uyarılar gibi detayları kullanıcı dostu bir formatta sunar. Bu sayede test süreçleri daha anlaşılır hale gelir ve hata tespiti kolaylaşır.

### Allure Üzerinden Sonuçları Görmek 

Allure, testlerin çalıştırılması sırasında üretilen test sonuçlarını JSON veya XML formatında `target/allure-results` klasörüne kaydeder. Bu veriler daha sonra Allure tarafından işlenir ve HTML formatında bir rapora dönüştürülür.

**Allure raporlarını görüntülemek için**:
   ```bash
   allure generate --single-file 
   allure open 
```

### Proje Hakkında

**Test Runner (src/main/java/testRunners)**:Bu sınıf, AbstractTestNGCucumberTests sınıfından miras alır, yani onun özelliklerini kullanabilir. Bu sınıf, TestNG ve Cucumber framework'lerini kullanarak test senaryolarını çalıştırmak için ayarlanmıştır.

**DriverFactory (src/main/java/util)**:Bu sınıf testlerin çalışması için gerekli olan tarayıcıyı başlatır ve ayarları yapar.

**ElementHelper (src/main/java/util)**:Bu sınıf, elementleri bulmak, tıklamak, metin göndermek ve görünürlüklerini kontrol etmek gibi sık kullanılan işlemleri kolaylaştırır.

**Hooks (src/main/java/util)**:Cucumber testleri çalıştırılmadan önce ve sonra yapılacak işlemleri tanımlar. Test öncesi ve sonrası işlemleri otomatikleştirerek testlerin sorunsuz başlamasını ve kapanmasını sağlar.

**ConfigReader (src/main/java/util)**:Bu sınıf, config.properties dosyasındaki yapılandırma ayarlarını okuyarak diğer sınıfların bu ayarlara erişimini sağlar.

**TestNG (src/test/resources)**:Bu XML dosyası, testRunners.runner sınıfı üzerinden Cucumber testlerini çalıştırır, testlerin "Chrome" tarayıcısında yapılmasını sağlar ve Allure raporlarını oluşturmak için dinleyici ekler.

**Diğer Elemanlar)**: .feautre dosyası src/main/java/Features paketinde Page classlarımız src/main/java/Pages paketinde StepDefinitionumuz src/main/java/StepDefinitions paketinde tutulmaktadır.