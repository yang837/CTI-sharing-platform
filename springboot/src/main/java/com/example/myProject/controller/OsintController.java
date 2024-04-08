package com.example.myProject.controller;

import com.example.myProject.dao.OsintDao;
import com.example.myProject.entity.Osint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class OsintController {

    @Autowired
    private OsintDao osintDao;

    @RequestMapping(value = "/osint", method = RequestMethod.GET)
    @ResponseBody
    public List<Osint> getAllOsint() {
        List<Osint> osintList = osintDao.getAllOsint();
        return osintList;
    }

}
