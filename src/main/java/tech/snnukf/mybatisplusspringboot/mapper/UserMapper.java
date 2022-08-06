package tech.snnukf.mybatisplusspringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tech.snnukf.mybatisplusspringboot.entity.User;

import java.util.Map;

/**
 * @className: UserMapper
 * @description: TODO 类描述
 * @author: simple.jbx
 * @date: 2022/7/31
 **/
@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息为map集合
     * @param id
     * @return
     */
    Map<String, Object> selectMapById(Long id);

    /**
     * 通过年龄查询用户信息并分页
     * @param page MyBatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param age
     * @return
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);
}
