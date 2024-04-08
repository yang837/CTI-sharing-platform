package com.example.myProject.dao;

import com.example.myProject.entity.Phonenum;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PhonenumDao {

    @Select("select * from phonenum")
    public List<Phonenum> getAllPhonenum();
}
