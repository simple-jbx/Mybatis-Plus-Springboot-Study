package tech.snnukf.mybatisplusspringboot.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.snnukf.mybatisplusspringboot.entity.Product;
import tech.snnukf.mybatisplusspringboot.mapper.ProductMapper;
import tech.snnukf.mybatisplusspringboot.service.IProductService;

/**
 * @className: ProductServiceImpl
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/8/9
 **/
@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
}
