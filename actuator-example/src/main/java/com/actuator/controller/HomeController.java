package com.actuator.controller;

import com.actuator.helper.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private Student student;

 @GetMapping("/get-data")
public Map<String,String> getData()
{

    return Map.of("Name","Ashok Thombre");
}

    @GetMapping("/home")
    public String home()
    {

        String name="Ashoka";
        String upperCase = name.toUpperCase();
        String lowerCase = name.toLowerCase();
        return lowerCase;
    }

}
