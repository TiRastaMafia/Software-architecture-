package ru.geekbrains.lesson8.models;

import ru.geekbrains.lesson8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class TableModel implements Model {


    private Collection<Table> tables;


    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables() {

        if (tables == null) {
            tables = new ArrayList<>();

            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     *
     * @param reservationDate Дата бронирования
     * @param tableNo         Номер столика
     * @param name            Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table : tables) {
            if (table.getNo() == tableNo) {
                Reservation reservation = new Reservation(table, reservationDate, name);
                table.getReservations().add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     *
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    public int changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name) {
        int deletedResult = deletingReservation(oldReservation);
        if(deletedResult > 0){
            int rezervationId = reservationTable(reservationDate, tableNo, name);
            return rezervationId;
        } else return -1;

    }

    private int deletingReservation(int reservationId){
        for (Table table : tables) {
            for(Reservation reservation : table.getReservations()){
                if(reservation.getId() == reservationId){
                    table.getReservations().remove(reservation);
                    return 1;
                }
            }
        }
        return -1;
    }

}
