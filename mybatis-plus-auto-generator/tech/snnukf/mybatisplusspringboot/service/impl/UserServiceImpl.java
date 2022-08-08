package tech.snnukf.mybatisplusspringboot.service.impl;

import tech.snnukf.mybatisplusspringboot.entity.User;
import tech.snnukf.mybatisplusspringboot.mapper.UserMapper;
import tech.snnukf.mybatisplusspringboot.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author simple
 * @since 2022-08-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
