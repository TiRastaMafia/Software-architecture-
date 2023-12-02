package ru.geekbrains.lesson3;

import java.util.HashMap;

public class CarWash implements Rewiping{

    HashMap<CategoryType, Integer> price = new HashMap<CategoryType, Integer>();

    public CarWash() {
        price.put(CategoryType.A, 1000);
        price.put(CategoryType.B, 2000);
        price.put(CategoryType.C, 3000);
    }

    @Override
    public void wipMirrors(CategoryType categoryType) {
        System.out.println("Стоимость мойки зеркал: " + 2 * price.get(categoryType) * 0.2);
    }

    @Override
    public void wipWindshield(CategoryType categoryType) {
        System.out.println("Стоимость мойки лобового стекла: " + price.get(categoryType) * 0.6);
    }

    @Override
    public void wipHeadlights(CategoryType categoryType) {
        System.out.println("Стоимость мойки фар: " + 4 * price.get(categoryType) * 0.2);
    }
}
