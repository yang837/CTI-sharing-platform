package com.example.myProject.dao;

import com.example.myProject.entity.test;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface testDao {
    @Select("select * from a where test=#{test} and test2=#{test2}")
    public test getName(test t);
}
