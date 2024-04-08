package com.example.myProject.controller;

import com.example.myProject.dao.PhishingipDao;
import com.example.myProject.entity.Phishingip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PhishingipController {

    @Autowired
    private PhishingipDao phishingipDao;

    @RequestMapping(value = "/phishingip", method = RequestMethod.GET)
    @ResponseBody
    public List<Phishingip> getAllPhishing() {
        List<Phishingip> phishingipList = phishingipDao.getAllPhishingip();
        return phishingipList;
    }

}
