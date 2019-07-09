package com.example.SpringDataRest.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

    @Id
//    @GeneratedValue(generator = "user_generator")
//    @SequenceGenerator(
//            name = "user_generator",
//            sequenceName = "user_sequence",
//            initialValue = 1000
//    )
    private Long id;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;
    @Column(name = "second_name", length = 150, nullable = false)
    private String secondName;
    @Column
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
