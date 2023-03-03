package com.kuang.pojp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "person")
@Validated
//@PropertySource("classpath:kkk.properties")
public class Person {
    //@Value("${name}")
    @Email(message = ("邮箱格式错误"))
    private String name;
    //@Value("${age}")
    private Integer age;
    private boolean happy;
    private Date birth;
    private Map<String ,Object> maps;
    private List<Object> lists;
    private Dog dog;
}
