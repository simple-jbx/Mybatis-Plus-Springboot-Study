package tech.snnukf.mybatisplusspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.snnukf.mybatisplusspringboot.enums.SexEnum;
import tech.snnukf.mybatisplusspringboot.mapper.UserMapper;
import tech.snnukf.mybatisplusspringboot.pojo.User;

/**
 * @className: MybatisPlusEnumTest
 * @description: 通用枚举类测试
 * @author: simple.jbx
 * @date: 2022/8/7
 **/
@SpringBootTest
public class MybatisPlusEnumTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSexEnum(){
        User user = new User();
        user.setName("Enum");
        user.setAge(20);
        //设置性别信息为枚举项，会将@EnumValue注解所标识的属性值存储到数据库
        user.setSex(SexEnum.MALE);
        //INSERT INTO t_user ( username, age, sex ) VALUES ( ?, ?, ? )
        //Parameters: Enum(String), 20(Integer), 1(Integer)
        userMapper.insert(user);
    }
}
