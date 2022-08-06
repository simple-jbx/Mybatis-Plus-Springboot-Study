package tech.snnukf.mybatisplusspringboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.snnukf.mybatisplusspringboot.entity.User;
import tech.snnukf.mybatisplusspringboot.mapper.UserMapper;

import java.util.List;
import java.util.Map;

/**
 * @className: MybatisPlusWrapperTest
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/1
 **/
@SpringBootTest
public class MybatisPlusWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test01() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "bo")
                        .between("age", 20, 25)
                                .isNotNull("email");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test02(){
        //按年龄降序查询用户，如果年龄相同则按id升序排列
        //SELECT id,name,age,email FROM user ORDER BY age DESC,id ASC
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .orderByDesc("age")
                .orderByAsc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test03(){
    //删除email为空的用户
    //DELETE FROM t_user WHERE (email IS NULL)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");
        //条件构造器也可以构建删除语句的条件
        int result = userMapper.delete(queryWrapper);
        System.out.println("受影响的行数：" + result);
    }


    @Test
    public void test041() {
        //将（年龄大于20并且用户名中包含有a）或邮箱为null的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .gt("age", 20)
                .like("name", "a")
                .or()
                .isNull("email");

        User user = new User();
        user.setName("小明");
        user.setEmail("test@snnukf.tech");

        //UPDATE user SET name=?, email=? WHERE (age > ? AND name LIKE ? OR email IS NULL)
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数 " + result);
    }


    @Test
    public void test042() {
        //将用户名中包含有a并且（年龄大于20或邮箱为null）的用户信息修改
        //Lambada中的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .like("name", "a")
                .and(i -> i.gt("age", 20).or().isNull("email"));

        User user = new User();
        user.setName("小明");
        user.setEmail("test@snnukf.tech");

        //UPDATE user SET name=?, email=? WHERE (name LIKE ? AND (age > ? OR email IS NULL))
        int result = userMapper.update(user, queryWrapper);
        System.out.println("受影响的行数 " + result);
    }


    @Test
    public void test05() {
        //查询用户信息的username和age字段
        //SELECT name,age FROM t_user
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        //selectMaps()返回Map集合列表，通常配合select()使用，避免User对象中没有被查询到的列值为null
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void test06() {
        //查询id小于等于3的用户信息
        //SELECT id,name,age,email FROM user WHERE (id IN (select id from user where id <= 5))
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("id", "select id from user where id <= 5");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
