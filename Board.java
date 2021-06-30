import java.util.Random;
import javax.swing.*;
import java.awt.*;



class Board {

  private Card[] deck;
  private int deckIndex;
  private final int maxSize = 48;
  private Card crane, janPoet, jan1, jan2, bush, febPoet, feb1, feb2, curtain,
    marPoet, mar1, mar2, cuckoo, aprTan, apr1, apr2, bridge, mayTan, may1,
    may2, butterfly, junPoet, jun1, jun2, boar, julTan, jul1, jul2, moon,
    geese, aug1, aug2, sake, sepPoet, sep1, sep2, deer, octPoet, oct1, oct2,
    ono, swallow, novTan, nov, phoenix, dec1, dec2, dec3;
  private Card[] table;
  private int tableSize;
  private final int maxTableSize = 12;

  public Board() {
    deck = new Card[maxSize];
    deckIndex = 0;
    table = new Card[12];
    initCards();
    setDeck();
    shuffle();
    setTable();
  }

  private void setTable(){
    for (int i = 0; i < 8; i++){
      table[i] = deck[deckIndex];
      removeFromDeck(deckIndex);
    }
  }

  private void setDeck(){
    deck[0] = crane;
    deck[1] = janPoet;
    deck[2] = jan1;
    deck[3] = jan2;
    deck[4] = bush;
    deck[5] = febPoet;
    deck[6] = feb1;
    deck[7] = feb2;
    deck[8] = curtain;
    deck[9] = marPoet;
    deck[10] = mar1;
    deck[11] = mar2;
    deck[12] = cuckoo;
    deck[13] = aprTan;
    deck[14] = apr1;
    deck[15] = apr2;
    deck[16] = bridge;
    deck[17] = mayTan;
    deck[18] = may1;
    deck[19] = may2;
    deck[20] = butterfly;
    deck[21] = junPoet;
    deck[22] = jun1;
    deck[23] = jun2;
    deck[24] = boar;
    deck[25] = julTan;
    deck[26] = jul1;
    deck[27] = jul2;
    deck[28] = moon;
    deck[29] = geese;
    deck[30] = aug1;
    deck[31] = aug2;
    deck[32] = sake;
    deck[33] = sepPoet;
    deck[34] = sep1;
    deck[35] = sep2;
    deck[36] = deer;
    deck[37] = octPoet;
    deck[38] = oct1;
    deck[39] = oct2;
    deck[40] = ono;
    deck[41] = swallow;
    deck[42] = novTan;
    deck[43] = nov;
    deck[44] = phoenix;
    deck[45] = dec1;
    deck[46] = dec2;
    deck[47] = dec3;
  }

  private void initCards(){
    crane = new Card(Month.JANUARY, CardType.HIKARI, "crane", "cardimages/crane.png");
    janPoet = new Card(Month.JANUARY, CardType.TANZAKU, "janPoet", "cardimages/janPoet.png");
    jan1 = new Card(Month.JANUARY, CardType.KASU, "jan1", "cardimages/jan1.png");
    jan2 = new Card(Month.JANUARY, CardType.KASU, "jan2", "cardimages/jan2.png");
    bush = new Card(Month.FEBRUARY, CardType.TANE, "bush", "cardimages/bush.png");
    febPoet = new Card(Month.FEBRUARY, CardType.TANZAKU, "febPoet", "cardimages/febPoet.png");
    feb1 = new Card(Month.FEBRUARY, CardType.KASU, "feb1", "cardimages/feb1.png");
    feb2 = new Card(Month.FEBRUARY, CardType.KASU, "feb2", "cardimages/feb2.png");
    curtain = new Card(Month.MARCH, CardType.HIKARI, "curtain", "cardimages/curtain.png");
    marPoet = new Card(Month.MARCH, CardType.TANZAKU, "marPoet", "cardimages/marPoet.png");
    mar1 = new Card(Month.MARCH, CardType.KASU, "mar1", "cardimages/mar1.png");
    mar2 = new Card(Month.MARCH, CardType.KASU, "mar2", "cardimages/mar2.png");
    cuckoo = new Card(Month.APRIL, CardType.TANE, "cuckoo", "cardimages/cuckoo.png");
    aprTan = new Card(Month.APRIL, CardType.TANZAKU, "aprTan", "cardimages/aprTan.png");
    apr1 = new Card(Month.APRIL, CardType.KASU, "apr1", "cardimages/apr1.png");
    apr2 = new Card(Month.APRIL, CardType.KASU, "apr2", "cardimages/apr2.png");
    bridge = new Card(Month.MAY, CardType.TANE, "bridge", "cardimages/bridge.png");
    mayTan = new Card(Month.MAY, CardType.TANZAKU, "mayTan", "cardimages/mayTan.png");
    may1 = new Card(Month.MAY, CardType.KASU, "may1", "cardimages/may1.png");
    may2 = new Card(Month.MAY, CardType.KASU, "may2", "cardimages/may2.png");
    butterfly = new Card(Month.JUNE, CardType.HIKARI, "butterfly", "cardimages/butterfly.png");
    junPoet = new Card(Month.JUNE, CardType.TANZAKU, "junPoet", "cardimages/junPoet.png");
    jun1 = new Card(Month.JUNE, CardType.KASU, "jun1", "cardimages/jun1.png");
    jun2 = new Card(Month.JUNE, CardType.KASU, "jun2", "cardimages/jun2.png");
    boar = new Card(Month.JULY, CardType.TANE, "boar", "cardimages/boar.png");
    julTan = new Card(Month.JULY, CardType.TANZAKU, "julTan", "cardimages/julTan.png");
    jul1 = new Card(Month.JULY, CardType.KASU, "jul1", "cardimages/jul1.png");
    jul2 = new Card(Month.JULY, CardType.KASU, "jul2", "cardimages/jul2.png");
    moon = new Card(Month.AUGUST, CardType.HIKARI, "moon", "cardimages/moon.png");
    geese = new Card(Month.AUGUST, CardType.TANE, "geese", "cardimages/geese.png");
    aug1 = new Card(Month.AUGUST, CardType.KASU, "aug1", "cardimages/aug1.png");
    aug2 = new Card(Month.AUGUST, CardType.KASU, "aug2", "cardimages/aug2.png");
    sake = new Card(Month.SEPTEMBER, CardType.TANE, "sake", "cardimages/sake.png");
    sepPoet = new Card(Month.SEPTEMBER, CardType.TANZAKU, "sepPoet", "cardimages/sepPoet.png");
    sep1 = new Card(Month.SEPTEMBER, CardType.KASU, "sep1", "cardimages/sep1.png");
    sep2 = new Card(Month.SEPTEMBER, CardType.KASU, "sep2", "cardimages/sep2.png");
    deer = new Card(Month.OCTOBER, CardType.TANE, "deer", "cardimages/deer.png");
    octPoet = new Card(Month.OCTOBER, CardType.TANZAKU, "octPoet", "cardimages/octPoet.png");
    oct1 = new Card(Month.OCTOBER, CardType.KASU, "oct1", "cardimages/oct1.png");
    oct2 = new Card(Month.OCTOBER, CardType.KASU, "oct2", "cardimages/oct2.png");
    ono = new Card(Month.NOVEMBER, CardType.HIKARI, "ono", "cardimages/ono.png");
    swallow = new Card(Month.NOVEMBER, CardType.TANE, "swallow", "cardimages/swallow.png");
    novTan = new Card(Month.NOVEMBER, CardType.TANZAKU, "novTan", "cardimages/novTan.png");
    nov = new Card(Month.NOVEMBER, CardType.KASU, "nov", "cardimages/nov.png");
    phoenix = new Card(Month.DECEMBER, CardType.HIKARI, "phoenix", "cardimages/phoenix.png");
    dec1 = new Card(Month.DECEMBER, CardType.KASU, "dec1", "cardimages/dec1.png");
    dec2 = new Card(Month.DECEMBER, CardType.KASU, "dec2", "cardimages/dec2.png");
    dec3 = new Card(Month.DECEMBER, CardType.KASU, "dec3", "cardimages/dec3.png");
  }

  private void removeFromDeck(int index){
      deck[deckIndex++] = null;
  }

  private void shuffle(){
    Random rand = new Random();
    Card buffer;
    int i,j;

    for (i = 0; i < 48; i++){
      j = rand.nextInt(48);
      buffer = deck[i];
      deck[i] = deck[j];
      deck[j] = buffer;
    }
  }

  public ImageIcon getTable(int index){
    //System.out.println("hello");
    if (table[index] != null){
      return table[index].getImg();
    }
    else return null;
  }


}
