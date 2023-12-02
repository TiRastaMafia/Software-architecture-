package ru.geekbrains.lesson6.database;

import java.util.*;

public class NotesTable {


    public NotesTable() {
        initialRecords();
    }

    private LinkedList<NotesRecord> records;

    public LinkedList<NotesRecord> getRecords() {
        return records;
    }

    public void removeRecord(int id){
        Iterator<NotesRecord> iterator = records.iterator();
        while (iterator.hasNext()){
            NotesRecord noteRecord = iterator.next();
            if (noteRecord.getId() == id){
                iterator.remove();
            }
        }
    }

    private void initialRecords(){
        Random random = new Random();
        if (records == null)
        {
            records = new LinkedList<>();
            int recordsCount =  5  + random.nextInt(10);
            for (int i = 0; i < recordsCount; i++){
                records.add(new NotesRecord("title #" + i, "details #" + i));
            }
        }
    }


}
