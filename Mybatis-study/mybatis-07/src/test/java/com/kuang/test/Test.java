package com.kuang.test;

import com.kuang.Mapper.TeacherMapper;
import com.kuang.pojo.Teacher;
import com.kuang.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Test {
    @org.junit.Test
    public void getTeacher(){
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }
}
