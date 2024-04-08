package com.example.myProject.dao;

import com.example.myProject.entity.Drdosip;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DrdosipDao {

    @Select("select * from drdosip")
    public List<Drdosip> getAllDrdosip();
}
