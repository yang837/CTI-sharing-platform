package com.example.myProject.dao;

import com.example.myProject.entity.Pmurl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PmurlDao {

    @Select("select * from pmurl")
    public List<Pmurl> getAllPmurl();
}
