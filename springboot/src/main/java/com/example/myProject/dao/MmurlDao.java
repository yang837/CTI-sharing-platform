package com.example.myProject.dao;

import com.example.myProject.entity.Mmurl;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MmurlDao {

    @Select("select * from mmurl")
    public List<Mmurl> getAllMmurl();
}
