package com.example.SpringDataRest.repository;

public interface UserRepositoryCustom {

    Integer getMaxUserAge();

    long updateUser(Long Id, String firstName, String secondName, Integer age);
}
