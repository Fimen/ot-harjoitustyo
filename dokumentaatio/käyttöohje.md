# Käyttöohje

Lataa tiedosto [ARKavustaja-viikko6.jar](https://github.com/Fimen/ot-harjoitustyo/releases/tag/viikko6)

## Ohjelman käynnistäminen

Ohjelma käynnistetään komennolla 

```
mvn compile exec:java -Dexec.mainClass=arkavustaja.Main
```

tai netbeansista suorittamalla ohjelma.

## Dinosauruksen ja tainnutusmetodin valitseminen

Valitse alasvetovalikosta haluamasi dinosaurus ja paina "tame" nappia

Seuraavassa näkymässä voit valita haluamasi tainnutusmetodin ja pääset eteenpäin klikkaamalla "knock out" nappia

## Leveleiden ennustaminen

Syöttämällä haluamasi tiedot ja klikkaamalla "calculate" saat laskettua todennäköisyyden kyseisen levelin (tason) saavuttamiseksi dinosauruksen kesyyntymisen jälkeen. ARK-pelissä villillä dinosauruksella on leveli joista dinosaurus saa parhaimmassa tapauksessa leveli / 2 - 1 määrän lisää leveleitä kesyyntymisen jälkeen. Tällöin jokaista saatua leveliä kohti peli arpoo yhden pisteen johonkin seitsemästä statsista (ominaisuudesta). Movement speed on ainoa ominaisuus, minkä kohdalla arvottu piste menee "hukkaan", joten ohjelmassa on näkyvillä vain kuusi muuta merkityksellistä ominaisuutta. Ohjelma siis laskee, että mikä on todennäköisyys, että esimerkiksi 150 levelisen dinosauruksen saamat 74 lisälevelistä vaikkapa esimerkiksi 30 leveliä arvotaan dinosauruksen strength ominaisuuteen. Ohjelma muuntaa annetut ominaisuuden luvut pisteiksi, jotka määräytyvät kunkin dinosauruksen kohdalla erikseen. Esimerkin dinosauruksen ominaisuuksien levelikertymästä voi nähdä [täältä](https://www.dododex.com/stat-calculator/ankylosaurus).

## Dinosauruksen lisääminen

Tällä hetkellä uuden dinosauruksen ja siihen liittyvien tarvittavien levelikohtaisten tasonnousujen lisääminen onnistuu ainoastaan lisäämällä dinos.txt tiedostoon formaatin mukaisesti uuden dinosauruksen tiedot. Tähän tarvittavat tiedot voi saada katsomalla halutun dinosauruksen nimen ja luvut [täältä](https://www.dododex.com/stat-calculator). Ohjelma lataa automaattisesti käynnistettäessä dinos.txt tiedostosta tiedot ja muuntaa ne ohjelman käytettävissä oleviksi olioiksi.
