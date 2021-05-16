# Testausdokumentti

Ohjelmaa on testattu NetBeansin testeillä, jotka on pääosin luotu jacoco-toiminnallisuuden avulla.

## Testaus

### Sovelluslogiikka

Testeillä on haluttu kattaa luokkien olioiden ja metodien testaus ja halutunlainen toiminta.

### DAO-luokka

DAO-luokan toiminnallisuus on testattu muokkaamalla ohjelman käynnissäolon aikana dinos.txt tiedostoa, hakemalla siitä oliot ohjelman käyttöön uudestaan ja tarkistamalla, että oliot antavat uudet muutetut arvot. Tämän jälkeen testiohjelma palauttaa muokatun tiedoston arvot takaisin alkuperäisiksi.

### Testauskattavuus

Käyttöliittymäkerrosta lukuunottamatta sovelluksen testauksen rivikattavuus on 83% ja haarautumakattavuus 72%

## Järjestelmätestaus

Sovelluksen järjestelmätestaus on suoritettu manuaalisesti.

## Sovellukseen jääneet laatuongelmat

Sovellus on osittain puuttellinen suunnitelluilta toiminnallisuuksiltaan

