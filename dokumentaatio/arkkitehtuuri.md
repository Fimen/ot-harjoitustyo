# Arkkitehtuuri

## Rakenne

Ohjelman pakkausrakenne noudattaa kolmitasoista kerrosarkkitehtuuria seuraavan kuvan mukaisesti:

<img src="https://raw.githubusercontent.com/Fimen/ot-harjoitustyo/master/dokumentaatio/image1.jpeg" width="300">

arkavustaja.ui sisältää JavaFX käyttöliittymän, arkavustaja.domain sovelluslogiikan ja arkavustaja.dao tiedostojen tallennustoiminnallisuuden.

## Käyttöliittymä

Käyttöliittymässä on kolme näkymää
  1. Dino
  2. Knocking
  3. Probability

Nämä on totetutettu Scene-olioilla, joita näytetään yksi kerrallaan Stage oliolla. Käyttöliittymän koodin on luokassa arkavustaja.ui.ARKavustajaUI

Käyttöliittymä on pyritty eristämään sovelluslogiikasta. Ohjelman rakenteen puolesta ei tarvinnut tehdä erillistä luokkaa asioiden hallitsemiselle vaan se onnistuu yksinkertaisesti käyttämällä DinoDao rajapintaa.

## Sovelluslogiikka

Tällä hetkellä sovelluslogiikka toimii Calc luokalla, Dino-olioilla ja DinoDao rajapinnalla, joita hyödynnetään ohjelmaa käytettäessä. 

<img src="https://raw.githubusercontent.com/Fimen/ot-harjoitustyo/master/dokumentaatio/image0.jpeg" width="150">

Ohjelman osian suhdetta kuvaava luokka/pakkauskaavio:

<img src="https://raw.githubusercontent.com/Fimen/ot-harjoitustyo/master/dokumentaatio/image2.jpeg" width="750">

## Tietojen pysyväistallennus

Pakkauksen arkavustaja.dao FileDinoDao huolehtii tietojen tallennuksesta ja hausta ohjelman käyttöön. Sovelluksen käynnistyessä FileDinoDao lukee dinos.txt tiedostosta sinne lisätyt dinosaurukset ja muodostaa niistä ohjelman käynnissäolon ajaksi tarpeelliset käytettävät oliot. Luokka on eriytetty Dao-rajapinnan taakse joten käyttöliittymä ei käytä luokkaa suoraan.

### Tiedostot

```
Ankylosaurus;700.0;175.0;150.0;3000.0;250.0;100.0;140.0;17.5;15.0;300.0;5.0;5.0
```
