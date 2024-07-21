package com.Alejandro.c24.repository;


import com.Alejandro.c24.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
