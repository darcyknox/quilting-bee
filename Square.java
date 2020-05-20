package quilting;

public class Square {

  double scale;
  double parentSize;
  double size;
  int r;
  int g;
  int b;

  public Square(double scale, double parentSize, int r, int g, int b) {
    this.scale = scale;
    this.parentSize = parentSize;
    this.r = r;
    this.g = g;
    this.b = b;
    this.size = parentSize * scale;
  }

}
