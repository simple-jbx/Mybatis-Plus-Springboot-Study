package tech.snnukf.mybatisplusspringboot.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @className: Product
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/7
 **/
@Data
public class Product {
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
