package com.example.SpringDataRest.controller;

import com.example.SpringDataRest.model.User;
import com.example.SpringDataRest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Random;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private static final String[] NAMES = new String[]{"Tom", "Jerry", "Donald"};

    @ResponseBody
    @RequestMapping("/")
    public String home() {
        String html = "";
        html += "<ul>";
        html += " <li><a href='/testInsert'>Test Insert</a></li>";
        html += " <li><a href='/showAllUsers'>Show All Users</a></li>";
        html += " <li><a href='/showFullNameLikeTom'>Show All 'Tom'</a></li>";
        html += " <li><a href='/deleteAllUsers'>Delete All Users</a></li>";
        html += "</ul>";
        return html;
    }

    @ResponseBody
    @RequestMapping("/testInsert")
    public String testInsert() {

        User user = new User();

        int random = new Random().nextInt(3);

        String fullName = NAMES[random] ;

        user.setId((long) 1000);
        user.setFirstName(fullName);
        user.setSecondName(fullName);
        this.userRepository.save(user);

        return "Inserted: " + user;
    }

    @ResponseBody
    @RequestMapping("/showAllUsers")
    public String showAllEmployee() {

        Iterable<User> users = this.userRepository.findAll();

        String html = "";
        for (User emp : users) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/showFullNameLikeTom")
    public String showFullNameLikeTom() {
        List<User> users = this.userRepository.findByFirstNameLike("Tom");

        String html = "";
        for (User emp : users) {
            html += emp + "<br>";
        }

        return html;
    }

    @ResponseBody
    @RequestMapping("/deleteAllUsers")
    public String deleteAllEmployee() {

        this.userRepository.deleteAll();
        return "Deleted!";
    }
}
