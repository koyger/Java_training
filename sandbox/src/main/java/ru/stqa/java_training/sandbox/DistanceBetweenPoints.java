package ru.stqa.java_training.sandbox;

public class DistanceBetweenPoints {
  public static void main(String[] args)
  {
    System.out.println("");
    Point p1 = new Point(3,56);
    Point p2 = new Point(44,53);
    System.out.println("(Функция в основном классе) Расстояние между точками равно " + distance(p1,p2));
    System.out.println("(Метод класса Point) Расстояние между точками равно " + p1.distance(p2));

  }
  public static double distance(Point p1, Point p2){
    return Math.sqrt( (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y) );

  }
}
