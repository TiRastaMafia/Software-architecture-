package com.example.homework7.repository;

import org.springframework.context.support.MessageSourceAccessor;

import java.util.List;

public interface DataBase<T>{
    List<T> getListObject();

    void save(T object);

    List<T> searchForName(String name);
}
