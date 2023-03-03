package com.example.kaoshi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Author LYL
 * @create 2021/7/28 8:33
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KaoShi {
    private Integer id;
    private String name;
    private String classNo;
    private String classId;
    private Date createTime;
}
