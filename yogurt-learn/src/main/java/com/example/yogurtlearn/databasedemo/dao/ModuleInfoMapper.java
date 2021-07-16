package com.example.yogurtlearn.databasedemo.dao;

import com.example.yogurtlearn.databasedemo.entity.ModuleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
public interface ModuleInfoMapper {

    @Select("select * from module_info where id = #{id}")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "module_name", property = "moduleName")
    })
    ModuleInfo findByModuleId(Integer id);

}