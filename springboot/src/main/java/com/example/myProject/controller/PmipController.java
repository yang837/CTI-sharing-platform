package com.example.myProject.controller;

import com.example.myProject.dao.PmipDao;
import com.example.myProject.entity.Pmip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmipController {

    @Autowired
    private PmipDao pmipDao;

    @RequestMapping(value = "/pmip", method = RequestMethod.GET)
    @ResponseBody
    public List<Pmip> getAllPmip() {
        List<Pmip> pmipList = pmipDao.getAllPmip();
        return pmipList;
    }

}
