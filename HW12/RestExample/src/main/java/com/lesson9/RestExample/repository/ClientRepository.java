package com.lesson9.RestExample.repository;


import com.lesson9.RestExample.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClientRepository extends JpaRepository<Client, Integer> {
}
