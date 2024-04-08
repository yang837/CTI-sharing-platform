package com.example.myProject.dao;

import com.example.myProject.entity.Pmip;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PmipDao {

    @Select("select * from pmip")
    public List<Pmip> getAllPmip();
}
