package com.company.Generics.GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("asd", "asdasd");
        String heavier = scale.getHeavier();
        System.out.println(heavier);
    }
}
