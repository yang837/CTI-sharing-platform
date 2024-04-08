package com.example.myProject.dao;

import com.example.myProject.entity.Phishingip;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhishingipDao {

    @Select("select * from phishingip")
    public List<Phishingip> getAllPhishingip();
}
