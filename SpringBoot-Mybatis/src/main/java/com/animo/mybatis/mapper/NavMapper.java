package com.animo.mybatis.mapper;

import com.animo.mybatis.entity.Nav;
import com.animo.mybatis.entity.ext.NavExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author 刘金泳
 * @Date 2019/10/25
 */
@Mapper
public interface NavMapper {

    /**
     * 保存
     * @param nav
     * @return
     */
    void save(Nav nav);

    /**
     * 根据Id获取导航栏
     * @param id
     * @return
     */
    Nav getById(Integer id);

    /**
     * 更新对象
     * @param nav
     */
    void update(Nav nav);

    /**
     * 保存多行记录
     * @param navList
     * @return
     */
    void saveList(List<Nav> navList);

    /**
     * 根据课程ID查询
     * @param key
     * @return
     */
    List<NavExt> getByKey(String key);

    List<Nav> getByLikeTest(Integer test);
}
