import java.awt.*;
import javax.swing.*;
import java.util.Scanner;
import java.util.ArrayList;

public class QuiltingBee extends JFrame {

  private static int frameSize = 500;
  private static int quiltSize = 450;
  private static ArrayList<Square> squares = new ArrayList<Square>();
  private static int baseSize;
  private static double accScale = 0.0;

  public QuiltingBee() {
    baseSize = (int)((double)quiltSize/accScale);
    setSize(frameSize, frameSize);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }

  public void paint(Graphics g) {
    // paints recursively
    quilt(g, frameSize/2, frameSize/2, 0);
  }

  public static void quilt(Graphics g, int x, int y, int i) {
    // Stop after final layer
    if (i == squares.size()) {
      return;
    } else {
      // Set square states
      squares.get(i).size = (int)(squares.get(i).scale * baseSize);
      squares.get(i).xCenter = x;
      squares.get(i).yCenter = y;
      int[] corners = Square.getCorners(squares.get(i));
      g.setColor(squares.get(i).rgb);
      // draw square
      g.fillRect(x - squares.get(i).size/2, y - squares.get(i).size/2, squares.get(i).size, squares.get(i).size);
      // draw square at each corner of the current square
      quilt(g, corners[0], corners[1], i + 1);
      quilt(g, corners[2], corners[3], i + 1);
      quilt(g, corners[4], corners[5], i + 1);
      quilt(g, corners[6], corners[7], i + 1);
    }
  }

  private static class Square extends JPanel {

    public double scale;
    public int size;
    public Color rgb;
    public int xCenter;
    public int yCenter;

    public Square(double scale, int r, int g, int b) {
      this.scale = scale;
      this.rgb = new Color(r, g, b);
    }

    // Points that next square layer will be centered on
    public static int[] getCorners(Square s) {
      int[] corners = new int[8];

      // Top left
      corners[0] = s.xCenter - s.size/2;
      corners[1] = s.yCenter + s.size/2;
      // Top right
      corners[2] = s.xCenter + s.size/2;
      corners[3] = s.yCenter + s.size/2;
      // Bottom right
      corners[4] = s.xCenter + s.size/2;
      corners[5] = s.yCenter - s.size/2;
      // Bottom left
      corners[6] = s.xCenter - s.size/2;
      corners[7] = s.yCenter - s.size/2;

      return corners;

    }

  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    while (scan.hasNextLine()) {
      String[] params = scan.nextLine().split(" ");
      double scale = Double.parseDouble(params[0]);
      accScale += scale;

      int[] color = new int[3];
      for (int i = 0; i < color.length; i++) {
        color[i] = Integer.parseInt(params[i + 1]);
      }

      Square layer = new Square(scale, color[0], color[1], color[2]);
      squares.add(layer);
    }

    QuiltingBee quilt = new QuiltingBee();
    scan.close();

  }
}
