package ru.stqa.java_training.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLDataException;


public class SquareTests {
    @Test
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals( s.area() ,25.0);
    }
}