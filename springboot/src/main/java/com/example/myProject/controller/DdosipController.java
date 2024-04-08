package com.example.myProject.controller;

import com.example.myProject.dao.DdosipDao;
import com.example.myProject.entity.Ddosip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@CrossOrigin
public class DdosipController {

    @Autowired
    private DdosipDao ddosipDao;

    @RequestMapping(value = "/ddosip", method = RequestMethod.GET)
    @ResponseBody
    public List<Ddosip> getAllDdosip() {
        List<Ddosip> ddosipList = ddosipDao.getAllDdosip();
        return ddosipList;
    }

}
