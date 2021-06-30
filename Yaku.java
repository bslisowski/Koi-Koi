
class Yaku {

  private int sankoCount, tsukimiCount, hanamiCount, inoshikochoCount, taneCount,
    noChofukuCount, akatanCount, aotanCount, tanzakuCount, kasuCount;
  private int[] tsukifudaArr;
  private boolean goko, shiko, ameShiko, sanko, tsukimi, hanami, inoshikocho, tane,
    noChofuku, akatan, aotan, tanzaku, tsukifuda, kasu;


  public Yaku(){
    sankoCount = 0;
    tsukimiCount = 0;
    hanamiCount = 0;
    inoshikochoCount = 0;
    taneCount = 0;
    noChofukuCount = 0;
    akatanCount = 0;
    aotanCount = 0;
    tanzakuCount = 0;
    kasuCount = 0;
    tsukifudaArr = new int[12];
    for (int i = 0; i < 12; i++){
      tsukifudaArr[i] = 0;
    }
    goko = false;
    shiko = false;
    ameShiko = false;
    sanko = false;
    tsukimi = false;
    hanami = false;
    inoshikocho = false;
    tane = false;
    noChofuku = false;
    akatan = false;
    aotan = false;
    tanzaku = false;
    kasu = false;
  }

  public boolean updateYaku(Card card){

    if (++tsukifudaArr[card.getMonth().ordinal()] == 3){
      return true;
    }
    boolean retVal = false;
    CardType month = card.getCardType();
    String name = card.toString();

    if (month == CardType.HIKARI){
      if (!goko){
        if (checkGoko())
          retVal = true;
      }
      else if (!shiko){
        if (checkShiko(name))
          retVal = true;
      }

      if (!tsukimi){
        if (checkTsukimi(name))
          retVal = true;
      }

      if (!hanami){
        if (checkHanami(name))
          retVal = true;
      }

    }
    else if (month == CardType.TANE){

      if (!inoshikocho){
        if (name.equals("butterfly") || name.equals("boar") || name.equals("deer")){
          if (++inoshikochoCount == 3)
            inoshikocho = true;
            retVal = true;
        }
      }
      else if (name.equals("sake") || name.equals("moon") || name.equals("curtain")){
        if (!tsukimi){
          if (checkTsukimi(name)){
            retVal = true;
          }
        }
        if (!hanami){
          if (checkHanami(name)){
            retVal = true;
          }
        }
      }

      if (++taneCount >= 5){
        tane = true;
        retVal = true;
      }

    }
    else if (month == CardType.TANZAKU){

      if (name.equals("janPoet") || name.equals("febPoet") || name.equals("marPoet")){
        if (++akatanCount == 3){
          akatan = true;
          retVal = true;
        }
      }
      else if (name.equals("junPoet") || name.equals("sepPoet") || name.equals("octPoet")){
        if (++aotanCount == 3) {
          aotan = true;
          retVal = true;
        }
      }

      if (akatan && aotan){
        noChofuku = true;
        retVal = true;
      }
      else{
        if (++tanzakuCount >= 5){
          tanzaku = true;
          retVal = true;
        }
      }
    }
    else {
      if (++kasuCount == 10){
        kasu = true;
        retVal = true;
      }
    }

    return retVal;

  }

  private boolean checkGoko(){
    if (shiko || ameShiko){
      shiko = false;
      ameShiko = false;
      goko = true;
      return true;
    }
    else return false;
  }


  private boolean checkShiko(String name){
    if (checkSanko()){
      if (name.equals("ono")){
        ameShiko = true;
        return true;
      }
      else {
        shiko = true;
        return true;
      }
    }
    else return false;
  }


  private boolean checkSanko(){
    if (++sankoCount == 3){
      sanko = true;
      return true;
    }
    else return false;
  }

  private boolean checkTsukimi(String name){
    if (name.equals("moon") || name.equals("sake")){
      if (++tsukimiCount == 2){
        tsukimi = true;
        return true;
      }
    }

    return false;
  }

  private boolean checkHanami(String name){
    if (name.equals("curtain") || name.equals("sake")){
      if (++hanamiCount == 2){
        hanami = true;
        return true;
      }
    }
    return false;
  }


}
