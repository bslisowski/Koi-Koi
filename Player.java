
class Player {

  private Card[] hand;
  private int cardCount;
  private final int maxHandSize = 8;
  private Yaku playerYaku;

  public Player(){
    playerYaku = new Yaku();
  }

  public void setHand(Card[] h){
    hand = h;
  }

  public void incCardCount(){
    cardCount++;
  }

  public void decCardCount(){
    cardCount--;
  }

}
