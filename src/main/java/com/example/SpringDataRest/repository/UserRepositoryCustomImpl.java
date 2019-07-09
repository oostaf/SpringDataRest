package com.example.SpringDataRest.repository;

import com.example.SpringDataRest.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    EntityManager entityManager;


    @Override
    public Integer getMaxUserAge() {
        String selectQuery = "SELECT coalesce(max(user.age), 0) FROM User user";
        Query query = entityManager.createQuery(selectQuery);
        return (Integer) query.getSingleResult();
    }

    @Override
    public long updateUser(Long id, String firstName, String secondName, Integer age) {
        User user = entityManager.find(User.class, id);
        if (user == null) {
            return 0;
        }
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setAge(age);
        entityManager.flush();
        return 1;
    }
}
