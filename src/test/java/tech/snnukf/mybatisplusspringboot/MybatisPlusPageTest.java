package tech.snnukf.mybatisplusspringboot;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.snnukf.mybatisplusspringboot.pojo.User;
import tech.snnukf.mybatisplusspringboot.mapper.UserMapper;

import java.util.List;

/**
 * @className: MybatisPlusPageTest
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/6
 **/
@SpringBootTest
public class MybatisPlusPageTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage(){
        //设置分页参数
        //SELECT COUNT(*) AS total FROM user
        //SELECT id,name,age,email FROM user LIMIT ?,?
        Page<User> page = new Page<>(2, 5);
        userMapper.selectPage(page, null);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }

    @Test
    public void testSelectPageVo(){
        //设置分页参数
        // SELECT COUNT(*) AS total FROM user WHERE age > ?
        // select id,name,age,email from user where age > ? LIMIT ?
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPageVo(page, 20);
        //获取分页数据
        List<User> list = page.getRecords();
        list.forEach(System.out::println);
        System.out.println("当前页："+page.getCurrent());
        System.out.println("每页显示的条数："+page.getSize());
        System.out.println("总记录数："+page.getTotal());
        System.out.println("总页数："+page.getPages());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("是否有下一页："+page.hasNext());
    }
}
