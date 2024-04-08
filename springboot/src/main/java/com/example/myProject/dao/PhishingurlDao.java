package com.example.myProject.dao;

import com.example.myProject.entity.Phishingurl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhishingurlDao {

    @Select("select * from phishingurl")
    public List<Phishingurl> getAllPhishingurl();
}
