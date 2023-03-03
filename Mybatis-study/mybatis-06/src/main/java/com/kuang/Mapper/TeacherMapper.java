package com.kuang.Mapper;

import com.kuang.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {
    @Select("select * from teacher where id = #{uid}")
    Teacher getTeacher(@Param("uid") int id);
}
