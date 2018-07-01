package ru.stqa.java_training.sandbox;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Collections {

    public static void main(String[] args)
    {
        String[] langs = {"Java","C#","Python","PHP"};

        for (String l : langs){
            System.out.println("Массив. Я хочу выучить "+ l);
        }

        List languages = Arrays.asList("Java","C#","Python","PHP");

        for (Object l : languages){
            System.out.println("Список. Я хочу выучить "+ l);
        }
        for (int i =0; i < languages.size(); i++) {
            System.out.println("Через i. Я хочу выучить "+ languages.get(i));
        }
    }
}
