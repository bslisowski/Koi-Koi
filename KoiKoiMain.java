import javax.swing.*;
import java.awt.*;


class KoiKoiMain extends JFrame{


  public static void main(String[] args){

    boolean isRunning = true;
    KoiKoiMain window = new KoiKoiMain();
    Board board = new Board();

    JPanel panel = new JPanel(new FlowLayout());
    panel.setPreferredSize(new Dimension(700,700));
    panel.setLayout(new GridLayout(2,4));
    //panel.add(new JLabel(board.getTable(0)));
    //panel.validate();
    //panel.repaint();

    for (int i = 0; i < 12; i++){
      ImageIcon temp = board.getTable(i);
      if (temp != null){
        panel.add(new JLabel(temp));
        panel.repaint();
      }
    }


    panel.setVisible(true);
    window.setSize(800,800);
    window.setDefaultCloseOperation(EXIT_ON_CLOSE);
    window.getContentPane().add(panel);
    window.setVisible(true);


    while(isRunning){
      System.out.println("hello");
      isRunning = false;
    }

  }
}
