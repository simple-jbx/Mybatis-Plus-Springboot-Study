package tech.snnukf.mybatisplusspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import tech.snnukf.mybatisplusspringboot.enums.SexEnum;

/**
 * @className: User
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/7/31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private SexEnum sex;
}
