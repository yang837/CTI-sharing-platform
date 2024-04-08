package com.example.myProject.controller;

import com.example.myProject.dao.testDao;
import com.example.myProject.entity.test;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class testCon {

    private final testDao testD;

    public testCon(testDao test) {
        this.testD = test;
    }

    @RequestMapping("/hello")
    @ResponseBody
    public boolean a() {
        test t = new test();
        t.setTest("x");
        t.setTest2("y");
        if (testD.getName(t) != null) {
            return true;
        }
        return false;
    }
}
