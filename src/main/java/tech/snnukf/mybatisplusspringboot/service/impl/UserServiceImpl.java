package tech.snnukf.mybatisplusspringboot.service.impl;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.snnukf.mybatisplusspringboot.pojo.User;
import tech.snnukf.mybatisplusspringboot.mapper.UserMapper;
import tech.snnukf.mybatisplusspringboot.service.IUserService;

/**
 * @className: UserServiceImpl
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/7/31
 **/
@DS("master")//指定所操作的数据源
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
