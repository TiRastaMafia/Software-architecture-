package ru.geekbrains.lesson3;

import java.awt.*;

public class SoprtCar extends Car implements Fueling, Wiping {
    public SoprtCar(String make, String model, Color color, CategoryType categoryType, FuelType fuelType) {
        super(make, model, color, fuelType, categoryType);
        setWheelsCount(3);
    }

    private Refueling refueling;


    private Rewiping carWash;

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    public void setRefuelingStation(Refueling refuelingStation) {
        this.refueling = refuelingStation;
    }

    public void setCarWash(Rewiping carWash) {
        this.carWash = carWash;
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

    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fuelType);
        }
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
