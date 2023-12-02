package ru.geekbrains.lesson6.notes.infrastructure.persistance;

import java.sql.SQLOutput;

public abstract class DbContext {

    protected Database database;

    public DbContext(Database database) {
        this.database = database;
    }

    protected abstract void onModelCreating(ModelBuilder builder);

    public boolean saveChanges(){
        //TODO: Сохранение изменений в БД
        System.out.println("Изменения сохранены!");
        return true;
    }
}

class ModelBuilder {

    public ModelBuilder applyConfiguration(ModelConfiguration configuration){
        //TODO: добавление конфигурации маппинга объекта некоторого типа к структуре таблицы БД
        return this;
    }

}
