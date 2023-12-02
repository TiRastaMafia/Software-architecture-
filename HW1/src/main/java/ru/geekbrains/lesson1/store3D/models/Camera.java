package ru.geekbrains.lesson1.store3D.models;

public class Camera {

    Point3D point3D;
    Angle3D angle3D;

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

    public void rotate(Angle3D rotate) {
        System.out.println(" УГОЛ ");
    }

    public void move(Point3D point3D) {
        System.out.println(" Сдвиг ");
    }
}
