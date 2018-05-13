package ru.stqa.java_training.sandbox;

public class Point {
  double x;
  double y;
  public Point(double x,double y){
    this.x = x;
    this.y = y;
  }
  public double distance(Point secondPoint){
    Point p1 = this;
    Point p2 = secondPoint;
    return Math.sqrt( (p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y) );
  }
}
