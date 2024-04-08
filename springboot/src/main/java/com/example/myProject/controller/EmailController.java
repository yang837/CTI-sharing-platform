package com.example.myProject.controller;

import com.example.myProject.dao.EmailDao;
import com.example.myProject.entity.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class EmailController {

    @Autowired
    private EmailDao emailDao;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    @ResponseBody
    public List<Email> getAllEmail() {
        List<Email> emailList = emailDao.getAllEmail();
        return emailList;
    }
}
