package com.animo.mybatis.entity.ext;

import com.animo.mybatis.entity.Nav;
import lombok.Data;
import java.util.List;

/**
 * @author 刘金泳
 * @Date 2019/10/25
 */
@Data
public class NavExt extends Nav {

    private List<NavExt> navExtList;

}
