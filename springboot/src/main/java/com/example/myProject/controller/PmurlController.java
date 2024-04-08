package com.example.myProject.controller;

import com.example.myProject.dao.PmurlDao;
import com.example.myProject.entity.Pmurl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmurlController {

    @Autowired
    private PmurlDao pmurlDao;

    @RequestMapping(value = "/pmurl", method = RequestMethod.GET)
    @ResponseBody
    public List<Pmurl> getAllPmurl() {
        List<Pmurl> pmurlList = pmurlDao.getAllPmurl();
        return pmurlList;
    }

}
