package ru.stqa.java_training.sandbox;
public class MyFirstProgram {

    public static void main(String[] args) {
        System.out.println("");
        hello("WORLD");
        hello("русское имя");
        double len = 5;
        System.out.println("Площадь квадрата со стороной "+len+" = " +area(len));
        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника со сторонами "+a+" и " +b+" = " +area(a,b));
    }
    public static void hello(String somebody) {
        System.out.println("Hello "+ somebody +"! Java Training.");
    }
    public static double area (double l){
        return l * l;
    }
    public static double area (double a, double b){
        return a * b ;
    }


}