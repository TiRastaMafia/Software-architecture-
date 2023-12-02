package ru.geekbrains.lesson3;

import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping {


    private Refueling refueling;


    private Rewiping carWash;

    public Harvester(String make, String model, Color color, CategoryType categoryType, FuelType fuelType) {
        super(make, model, color, fuelType, categoryType);
        setWheelsCount(6);
    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    public void setCarWash(Rewiping carWash) {
        this.carWash = carWash;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweeping() {
        System.out.println("Автомобиль метет улицу.");
    }


    @Override
    public void wipMirrors() {
        if (carWash != null) {
            carWash.wipMirrors(getCategoryType());
        }
    }

    @Override
    public void wipWindshield() {
        if (carWash != null) {
            carWash.wipWindshield(getCategoryType());
        }

    }

    @Override
    public void wipHeadlights() {
        if (carWash != null){
            carWash.wipHeadlights(getCategoryType());
        }

    }
}
