package quilting;

import javax.swing.*;

public class QuiltApp{

  public static void main(String[]args){
    JFrame frame = new JFrame("Quilt");
    frame.getContentPane().add(new QuiltPanel());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
