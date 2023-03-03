package com.kuang.Mapper;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {
    //获取数据库中的所有老师
    //List<Teacher> getTeacher();

    //获取指定老师下的所有学生及老师的信息m
    Teacher getTeacher(@Param("tid") int id);
}
