package com.example.myProject.dao;

import com.example.myProject.entity.Ddosip;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DdosipDao {

    @Select("select * from ddosip")
    public List<Ddosip> getAllDdosip();
}
