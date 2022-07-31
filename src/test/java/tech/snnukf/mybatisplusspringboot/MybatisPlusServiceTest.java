package tech.snnukf.mybatisplusspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.snnukf.mybatisplusspringboot.entity.User;
import tech.snnukf.mybatisplusspringboot.service.IUserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @className: MybatisPlusServiceTest
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/7/31
 **/
@SpringBootTest
public class MybatisPlusServiceTest {

    @Autowired
    private IUserService iUserService;

    @Test
    public void testGetCount() {
        // SELECT COUNT( * ) FROM user
        long count = iUserService.count();
        System.out.println("记录数 ==> " + count);
    }

    /**
     * @param:
     * @description: 批量添加
     * @return:
     * @author: simple.jbx
     * @date: 2022/7/31
     */
    @Test
    public void testInsertMore() {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("bo" + i);
            user.setAge(20 + i);
            list.add(user);
        }

        //INSERT INTO user ( id, name, age ) VALUES ( ?, ?, ? )
        boolean res = iUserService.saveBatch(list);
        System.out.println(res);
    }
}
