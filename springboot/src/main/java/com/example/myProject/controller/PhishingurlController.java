package com.example.myProject.controller;

import com.example.myProject.dao.PhishingurlDao;
import com.example.myProject.entity.Phishingurl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@CrossOrigin
public class PhishingurlController {

    @Autowired
    private PhishingurlDao phishingurlDao;

    @RequestMapping(value = "/phishingurl", method = RequestMethod.GET)
    @ResponseBody
    public List<Phishingurl> getAllPhishingurl() {
        List<Phishingurl> phishingurlList = phishingurlDao.getAllPhishingurl();
        return phishingurlList;
    }

}
