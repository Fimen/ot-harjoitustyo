# Vaatimusmäärittely

## Sovelluksen tarkoitus

Sovelluksen avulla pystyy suunnitella ARK-pelin otuksen kesytyksen mahdollisimman optimaalisesti ja näkemään todennäköisyydet halutuille otuksen ominaisuustasoille kesytyksen jälkeen. 

## Käyttäjät

Kesytys kestää vain tietyn hetken jolloin tietoja tarvii, joten alustavasti tarvetta useammalle käyttäjälle ei ole.

## Käyttöliittymäluonnos

Sovellus koostuu kolmesta eri näkymästä ainakin toistaiseksi kunnes paljastuu kuinka iso työmaa alustavassa versiossa on.

<img src="https://raw.githubusercontent.com/Fimen/ot-harjoitustyo/master/dokumentaatio/kayttoliittymaluonnos.jpeg" width="750">

## Perusversion tarjoama toiminnallisuus

### Dinosauruksen valinta

- käyttäjä valitsee haluamansa dinosauruksen valikosta. Alussa siellä on vain yksi laji [TEHTY]

- valinnan jälkeen käyttäjä klikkaa "Tame" jolloin päästään tainnutusmetodin valintanäkymään [TEHTY]

- käyttöliittymäkuvaan lisäyksenä käyttäjä asettaa pelaamansa serverin kertoimet kesytysnopeuksille

### Tainnutusmetodin valinta

- käyttäjä valitsee haluamansa aseen valikosta. Alustavasti kätettävissä on ainoastaan yhdenlainen tainnutusase [TEHTY]

- käyttäjä muuttaa tarvittaessa aseen vahvuutta

- käyttäjä näkee tarvittavat tiedot tainnutuksen suorittamiseen

- käyttäjä voi klikata "Knocked out" ilmaistaakseen tainnutuksen onnistumisen ja päästäkseen Ominaisuusnäkymään [TEHTY]

### Ominaisuusnäkymä

- käyttäjä valitsee kesytyksessä käytettävän ruoan [TEHTY]

- käyttöliittymäkuvaan lisäyksenä käyttäjä asettaa kesytettävän dinosauruksen tason [TEHTY]

- käyttäjä asettaa kesytettävän dinosauruksen ominaisuuksien tasot [TEHTY]

- käyttäjä asettaa haluamiinsa ominaisuuksiin tavoitetason [TEHTY]

- käyttäjä näkee kuinka todennäköistä on saavuttaa haluttu taso kesytyksen onnistuessa [TEHTY]

- käyttäjä voi poistua takaisin ensimmäisen valikkoon painamalla "Ready!"

## Jatkokehitysideoita

Perusversion jälkeen ohjelmaa täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla

- uusien otuksien lisääminen
- uusien tainnutusaseiden lisääminen
- passiivisesti kesytettävien otusten lisääminen
- passiivisesti kesytettävien otusten kesytysmetodien lisääminen
- kesytettävän otuksen ominaisuuksien tasojen hakeminen esim screenshotista
- ajastimen ja herätyskellon lisääminen
- optimaalisen kesytyssuunnitelman näkymän lisääminen
- kesytettyjen otusten tilastointi
