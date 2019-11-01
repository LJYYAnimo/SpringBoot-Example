package com.animo.mybatis.service;

import com.animo.mybatis.entity.Nav;
import com.animo.mybatis.entity.ext.NavExt;
import com.animo.mybatis.mapper.NavMapper;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

/**
 * @author 刘金泳
 * @Date 2019/10/25
 */
@Service
public class NavService {

    @Resource
    NavMapper navMapper;

    public void save(Nav nav){
       navMapper.save(nav);
    }

    public Nav getById(Integer id){
        return navMapper.getById(id);
    }

    public void saveList(List<Nav> navList){
        navMapper.saveList(navList);
    }

    public List<NavExt> getByKey(String key){
       return navMapper.getByKey(key);
    }

    /**
     * 如果异常不抛出或者不手动回滚则事物不会回滚
     *
     *
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)
    public void transactionalTest(Integer id){
        try {
            //1.先查询
            Nav nav = navMapper.getById(id);
            //2.更新
            nav.setName("事物测试更新");
            navMapper.update(nav);
            //3.新增
            navMapper.save(new Nav("事物测试保存",3));
            FileOutputStream fileOutputStream = new FileOutputStream(new File("/usr/local/xxx.html"));
            //.....重要代码
        }catch (IOException e){
            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
    }

    public final void animoTest(){
        System.out.println("21212");
    }
}
