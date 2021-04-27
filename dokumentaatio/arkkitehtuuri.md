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

Vielä tällä hetkellä sovelluslogiikka toimii Dino-olioilla ja DinoDao rajapinnalla, joita hyödynnetään ohjelmaa käytettäessä. 

<img src="https://raw.githubusercontent.com/Fimen/ot-harjoitustyo/master/dokumentaatio/image0.jpeg" width="150">

Ohjelman osian suhdetta kuvaava luokka/pakkauskaavio:

<img src="https://raw.githubusercontent.com/Fimen/ot-harjoitustyo/master/dokumentaatio/image2.jpeg" width="750">
