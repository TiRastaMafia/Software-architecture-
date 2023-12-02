package ru.geekbrains.lesson1.store3D.models;

import java.lang.reflect.Type;
import java.util.List;

public class Scene {

    int id;
    private List<PoligonalModel> models;
    private List<Flash> flashes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<PoligonalModel> getModels() {
        return models;
    }

    public List<Flash> getFlashes() {
        return flashes;
    }

    public void setModels(List<PoligonalModel> models) {
        this.models = models;
    }


    public void setFlashes(List<Flash> flashes) {
        this.flashes = flashes;
    }

    public void method1(Type method1) {

    }
    public void method2(Type method2) {

    }

}
