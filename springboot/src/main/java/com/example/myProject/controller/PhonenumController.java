package com.example.myProject.controller;

import com.example.myProject.dao.PhonenumDao;
import com.example.myProject.entity.Phonenum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PhonenumController {

    @Autowired
    private PhonenumDao phonenumDao;

    @RequestMapping(value = "/phonenum", method = RequestMethod.GET)
    @ResponseBody
    public List<Phonenum> getAllPhonenum() {
        List<Phonenum> phonenumList = phonenumDao.getAllPhonenum();
        return phonenumList;
    }

}
