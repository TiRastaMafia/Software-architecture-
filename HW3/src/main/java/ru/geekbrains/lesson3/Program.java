package ru.geekbrains.lesson3;

import java.awt.*;

public class Program {

    /**
     * 1. Спроектировать абстрактный класс «Car» у которого должны
     * быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
     * топлива, тип коробки передач, объём двигателя; методы:
     * движение, обслуживание, переключение передач, включение
     * фар, включение дворников.
     * <p>
     * 2. Создать конкретный автомобиль путём наследования класса
     * «Car».
     * 3. Расширить абстрактный класс «Car», добавить метод: подметать
     * улицу. Создать конкретный автомобиль путём наследования
     * класса «Car». Провести проверку принципа SRP.
     * <p>
     * 4. Расширить абстрактный класс «Car», добавить метод:
     * включение противотуманных фар, перевозка груза. Провести
     * проверку принципа OCP.
     * <p>
     * 5. Создать конкретный автомобиль путём наследования класса
     * «Car», определить число колёс = 3. Провести проверку принципа LSP.
     * <p>
     * 6. Создать конкретный автомобиль путём наследования класса
     * «Car», определить метод «движение» - «полёт». Провести
     * проверку принципа LSP.
     * <p>
     * 7. Создать интерфейс «Заправочная станция», создать метод:
     * заправка топливом.
     * <p>
     * <p>
     * 8. Имплементировать метод интерфейса «Заправочная станция» в
     * конкретный класс «Car».
     * <p>
     * 9. Добавить в интерфейс «Заправочная станция» методы: протирка
     * лобового стекла, протирка фар, протирка зеркал.
     * <p>
     * 10. Имплементировать все методы интерфейса «Заправочная
     * станция» в конкретный класс «Car». Провести проверку
     * принципа ISP. Создать дополнительный/е интерфейсы и
     * имплементировать их в конкретный класс «Car». Провести
     * проверку принципа ISP.
     * <p>
     * 11. Создать путём наследования класса «Car» два
     * автомобиля: с бензиновым и дизельным двигателями,
     * имплементировать метод «Заправка топливом» интерфейса
     * «Заправочная станция». Реализовать заправку каждого
     * автомобиля подходящим топливом. Провести проверку принципа DIP.
     *
     * @param args
     */

    public static void main(String[] args) {

        Harvester car1 = new Harvester("A", "A", Color.BLACK, CategoryType.C, FuelType.Diesel);
        Harvester car2 = new Harvester("B", "B", Color.RED, CategoryType.C, FuelType.Gasoline);
        SoprtCar car3 = new SoprtCar("C", "C", Color.YELLOW, CategoryType.B, FuelType.Diesel);
        SoprtCar car4 = new SoprtCar("D", "D", Color.WHITE, CategoryType.A, FuelType.Gasoline);

        RefuelingStation refuelingStation = new RefuelingStation();
        CarWash carWash = new CarWash();

        car1.setRefuelingStation(refuelingStation);
        car2.setRefuelingStation(refuelingStation);
        car3.setRefuelingStation(refuelingStation);
        car4.setRefuelingStation(refuelingStation);

        car1.setCarWash(carWash);
        car2.setCarWash(carWash);
        car3.setCarWash(carWash);
        car4.setCarWash(carWash);


        System.out.println("harvester1");
        car1.wipMirrors();
        car1.wipHeadlights();
        car1.wipWindshield();

        System.out.println("\nharvester2");
        car2.wipMirrors();
        car2.wipHeadlights();
        car2.wipWindshield();

        System.out.println("\nSportCar1");
        car3.wipMirrors();
        car3.wipHeadlights();
        car3.wipWindshield();

        System.out.println("\nSportCar2");
        car4.wipMirrors();
        car4.wipHeadlights();
        car4.wipWindshield();

        System.out.println("\nharvester1");
        car1.fuel();

        System.out.println("\nharvester2");
        car2.fuel();

        System.out.println("\nSportCar1");
        car3.fuel();

        System.out.println("\nSportCar2");
        car4.fuel();


    }

    public static double calculateMaintenance(Car car) {
        if (car.getWheelsCount() == 6) {
            return 1500 * 6;
        } else {
            return 1000 * 4;
        }
    }

}
