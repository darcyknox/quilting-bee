package quilting;

import java.awt.*;
import javax.swing.JFrame;
import java.util.Scanner;

public class QuiltPanel extends JPanel {
  double scale;
  int size;
  Color rgb;
  int baseSize;
  int FRAMESIZE = 600;

  public QuiltPanel(int baseSize, double scale, int r, int g, int b) {

    this.baseSize = baseSize;
    this.scale = scale;
    this.size = (int) (baseSize * scale);
    this.rgb = new Color(r, g, b);

    setSize(600, 600);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void paint(Graphics g) {
    g.setColor(this.rgb);
    g.fillRect(FRAMESIZE/2 - this.size/2, FRAMESIZE/2 - this.size/2, this.size, this.size);
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int parentSize = 500;

    while (scan.hasNextLine()) {
      System.out.print("First line: ");
      String[] params = scan.nextLine().split(" ");
      double scale = Double.parseDouble(params[0]);

      parentSize = (int) (parentSize * scale);

      int[] color = new int[3];

      for (int i = 0; i < color.length; i++) {
        color[i] = Integer.parseInt(params[i + 1]);
      }
      System.out.println(params);

      QuiltPanel layer = new QuiltPanel(500, scale, color[0], color[1], color[2]);
      base.repaint();
    }



    while (scan.hasNextLine()) {
      String[] params = scan.nextLine().split(" ");

      double scale = Double.parseDouble(params[0]);

      int[] color = new int[3];

      for (int i = 0; i < color.length; i++) {
        color[i] = Integer.parseInt(params[i + 1]);
      }

      QuiltPanel layer = new QuiltPanel(parentSize, scale, color[0], color[1], color[2]);
      layer.repaint();

      parentSize = (int) (parentSize * scale);

    }



  }

}
