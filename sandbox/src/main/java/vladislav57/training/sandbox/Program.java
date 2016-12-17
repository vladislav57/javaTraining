package vladislav57.training.sandbox;

import static java.lang.Math.sqrt;

public class Program {

  public static void main(String[] args) {
    System.out.println("Hello, world!");

    Point firstPoint = new Point(5, 6);
    Point secondPoint = new Point(1, 3);

    System.out.println(distance(firstPoint, secondPoint));
    System.out.println(firstPoint.distanceTo(secondPoint));
  }

  public static double distance(Point a, Point b) {
    double deltaX = a.x - b.x;
    double deltaY = a.y - b.y;
    return sqrt(deltaX*deltaX + deltaY*deltaY);
  }

}
