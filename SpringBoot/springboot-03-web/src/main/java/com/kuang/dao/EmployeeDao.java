package com.kuang.dao;

import com.kuang.pojo.Department;
import com.kuang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository  //被spring托管
//员工Dao
public class EmployeeDao {
    //模拟数据库中的数据
    private static Map<Integer, Employee> employeetMap = null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeetMap = new HashMap<>();
        employeetMap.put(1001,new Employee(1001,"AA","A2389407153@qq.com",1,new Department(101,"教学楼")));
        employeetMap.put(1002,new Employee(1002,"BB","B2389407153@qq.com",1,new Department(101,"市场部")));
        employeetMap.put(1003,new Employee(1003,"DD","C2389407153@qq.com",1,new Department(101,"教研部")));
        employeetMap.put(1004,new Employee(1004,"DD","D2389407153@qq.com",1,new Department(101,"运营部")));
        employeetMap.put(1005,new Employee(1005,"EE","E2389407153@qq.com",1,new Department(101,"后勤部")));
    }
    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void  save(Employee employee){
        if (employee.getId() == null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeetMap.put(employee.getId(),employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employeetMap.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employeetMap.get(id);
    }


    //删除员工通过id
    public void delete(Integer id){
        employeetMap.remove(id);
    }
}
