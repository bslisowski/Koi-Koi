import javax.swing.ImageIcon;
import java.awt.*;

class Card {

  private Month month;
  private CardType type;
  private String name;
  private ImageIcon img;

  public Card(Month m, CardType t, String n, String i){
    month = m;
    type = t;
    name = n;
    img = new ImageIcon(i); // load the image to a imageIcon
    Image image = img.getImage(); // transform it
    Image newimg = image.getScaledInstance(120, 120,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
    img = new ImageIcon(newimg);  // transform it back

  }

  public Month getMonth(){
    return month;
  }

  public CardType getType(){
    return type;
  }

  public String toString(){
    return name;
  }

  public ImageIcon getImg(){
    return img;
  }
}
