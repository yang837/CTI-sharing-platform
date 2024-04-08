package com.example.myProject.controller;

import com.example.myProject.dao.MmurlDao;
import com.example.myProject.entity.Mmurl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class MmurlController {

    @Autowired
    private MmurlDao mmurlDao;

    @RequestMapping(value = "/mmurl", method = RequestMethod.GET)
    @ResponseBody
    public List<Mmurl> getAllMmurl() {
        List<Mmurl> mmurlList = mmurlDao.getAllMmurl();
        return mmurlList;
    }

}
