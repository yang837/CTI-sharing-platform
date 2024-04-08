package com.example.myProject.dao;

import com.example.myProject.entity.Mmip;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MmipDao {

    @Select("select * from mmip")
    public List<Mmip> getAllMmip();
}
