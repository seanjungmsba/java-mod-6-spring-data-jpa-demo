package com.example.springdatajpaexample.repositories;

import com.example.springdatajpaexample.models.Teacher;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends CrudRepository<Teacher, Integer> {

    // Note that we don’t have to add any method implementations to this repository.
    // Spring will automatically create an object that implements the TeacherRepository repository with all the CRUD methods and inject into the Spring context.
}
