Feature: Enuygun Sitesi Kontrolleri

  @Case1
  Scenario: İstanbul-Ankara arası gidiş dönüş uçuş araması ve saat kontrolü Case1
    Given "İstanbul" , "Ankara" Parametreleri ile Arama Yapmaya Başlar
    When Tarih bilgileri parametre olarak girilir "2024-12-19" "2024-12-25"
    And Yolcu bilgileri parametre olarak girilir  3 1 2 "Ekonomi"
    When Arama Butonuna Tıklanır
    When Kalkış saati filtresinde kalkış saatleri "10:00" ile "18:00" arası seçilir
    Then Tüm uçuşların kalkış saatleri 10:00 ile 18:00 arasında olmalıdır

  @Case2
    Scenario: İstanbul-Ankara arası gidiş dönüş uçuş araması ve fiyat kontrolü Case2
      Given "İstanbul" , "Ankara" Parametreleri ile Arama Yapmaya Başlar
      When Tarih bilgileri parametre olarak girilir "2024-12-15" "2024-12-18"
      And Yolcu bilgileri parametre olarak girilir  3 1 2 "Ekonomi"
      When Arama Butonuna Tıklanır
      When Kalkış saati filtresinde kalkış saatleri "10:00" ile "18:00" arası seçilir
      When Havayolu sirketi olarak Türk Hava Yolları seçilir
      Then Fiyatların küçükten büyüğe sıralandığı kontrol edilir

@Case3
  Scenario: Kullanıcı başarılı bir şekilde yolcu bilgileri bölümüne gider ve formu doldurur
    Given "İstanbul" , "Ankara" Parametreleri ile Arama Yapmaya Başlar
    When Arama Butonuna Tıklanır
    And En yukarıdaki bilet seçilir
    And Dönüş bileti seçilir
    When Formlar Validate Edilir
    And Hata Mesajları Validate Edilir
