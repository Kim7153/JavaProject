package com.kuang.dao;

import com.kuang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository  //被spring托管
public class DepartmentDao {
    //模拟数据库中的数据
    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap = new HashMap<>();

        departmentMap.put(101,new Department(101,"教学楼"));
        departmentMap.put(102,new Department(102,"市场部"));
        departmentMap.put(103,new Department(103,"教研部"));
        departmentMap.put(104,new Department(104,"运营部"));
        departmentMap.put(105,new Department(105,"后勤部"));
    }

    //获得所有部门信息
    public Collection<Department> getDepartment(){
        return departmentMap.values();
    }
    //通过id获得部门
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
