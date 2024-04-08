package com.example.myProject.dao;

import com.example.myProject.entity.Osint;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface OsintDao {

    @Select("select * from osint")
    public List<Osint> getAllOsint();
}
