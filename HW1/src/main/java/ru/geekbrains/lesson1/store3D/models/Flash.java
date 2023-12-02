package ru.geekbrains.lesson1.store3D.models;

import java.awt.*;

public class Flash {

    Point3D point3D;
    Angle3D angle3D;
    Color color;
    Float power;

    public Point3D getPoint3D() {
        return point3D;
    }

    public void setPoint3D(Point3D point3D) {
        this.point3D = point3D;
    }

    public Angle3D getAngle3D() {
        return angle3D;
    }

    public void setAngle3D(Angle3D angle3D) {
        this.angle3D = angle3D;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Float getPower() {
        return power;
    }

    public void setPower(Float power) {
        this.power = power;
    }

    public void rotate(Angle3D rotate) {
        System.out.println(" УГОЛ ");
    }

    public void move(Point3D move) {
        System.out.println(" Сдвиг ");
    }

}
