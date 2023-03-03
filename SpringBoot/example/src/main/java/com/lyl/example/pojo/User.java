package com.lyl.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //用户id
    private Integer id;
    private String name;
    private Double sal;
    private Integer age;
}
