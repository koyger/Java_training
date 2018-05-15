package ru.stqa.java_training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
    @Test
    public void distance(){
        Point p1 = new Point(3,56);
        Point p2 = new Point(44,53);
        Assert.assertEquals( p1.distance(p2) , 41.10960958218893 ); // две произвольные точки

        Point p3 = new Point(3,56);
        Point p4 = new Point(3,56);
        Assert.assertEquals( p3.distance(p4) , 0.0 ); // две совпадающие точки

        Point p5 = new Point(3,56);
        Point p6 = new Point(-7,56);
        Assert.assertEquals( p5.distance(p6) , 10.0 ); // точки отличаются только X, и он переходит через 0

        Point p7 = new Point(-7,1.0e10);
        Point p8 = new Point(-7,57.0e10);
        Assert.assertEquals( p7.distance(p8) , 56.0e10 ); // точки отличаются только Y, и расстояние большое
    }
}
