package tech.snnukf.mybatisplusspringboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tech.snnukf.mybatisplusspringboot.service.IProductService;
import tech.snnukf.mybatisplusspringboot.service.IUserService;

/**
 * @className: MybatisPlusDynamicDataSource
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/9
 **/
@SpringBootTest
public class MybatisPlusDynamicDataSource {
    @Autowired
    private IUserService userService;
    @Autowired
    private IProductService productService;
    @Test
    public void testDynamicDataSource(){
        System.out.println(userService.getById(1L));
        System.out.println(productService.getById(1L));
    }
}
