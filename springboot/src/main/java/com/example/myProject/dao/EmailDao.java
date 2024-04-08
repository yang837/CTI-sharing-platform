package com.example.myProject.dao;

import com.example.myProject.entity.Email;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmailDao {

    @Select("select * from email")
    public List<Email> getAllEmail();
}
