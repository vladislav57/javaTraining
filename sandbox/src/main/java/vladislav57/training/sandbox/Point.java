package vladislav57.training.sandbox;

import static java.lang.Math.sqrt;

public class Point {

  public double x;
  public double y;

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double distanceTo(Point a) {
    double deltaX = this.x - a.x;
    double deltaY = this.y - a.y;
    return sqrt(deltaX*deltaX + deltaY*deltaY);
  }

}
