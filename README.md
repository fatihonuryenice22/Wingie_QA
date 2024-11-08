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

### Adımlar

1. Projeyi bilgisayarınıza klonlayın:
   ```bash
   git clone https://github.com/fatihonuryenice22/Wingie_QA.git
   ```
2. Klonlanan dizine gidin:
   ```bash
   cd Wingie_QA
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

Tüm senaryolar `src/test/resources/features` klasöründe Gherkin dili ile yazılmıştır. Her senaryo kullanıcı hikayelerini ve uygulamanın doğru çalışmasını doğrulamak için özel olarak tasarlanmıştır.

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



---


