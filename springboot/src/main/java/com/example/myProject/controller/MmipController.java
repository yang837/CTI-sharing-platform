package com.example.myProject.controller;

import com.example.myProject.dao.MmipDao;
import com.example.myProject.entity.Mmip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class MmipController {

    @Autowired
    private MmipDao mmipDao;

    @RequestMapping(value = "/mmip", method = RequestMethod.GET)
    @ResponseBody
    public List<Mmip> getAllMmip() {
        List<Mmip> mmipList = mmipDao.getAllMmip();
        return mmipList;
    }

}
