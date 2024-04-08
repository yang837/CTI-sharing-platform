package com.example.myProject.controller;

import com.example.myProject.dao.DrdosipDao;
import com.example.myProject.entity.Drdosip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class DrdosipController {

    @Autowired
    private DrdosipDao drdosipDao;

    @RequestMapping(value = "/drdosip", method = RequestMethod.GET)
    @ResponseBody
    public List<Drdosip> getAllDrdosip() {
        List<Drdosip> drdosipList = drdosipDao.getAllDrdosip();
        return drdosipList;
    }

}
