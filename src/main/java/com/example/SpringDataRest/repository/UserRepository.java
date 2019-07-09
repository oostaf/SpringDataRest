package com.example.SpringDataRest.repository;

import com.example.SpringDataRest.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByFirstName(String name);

    List<User> findByFirstNameLike(String name);

    List<User> findByAgeGreaterThan(int age);

    List<User> findByAgeLessThan(int age);
}
