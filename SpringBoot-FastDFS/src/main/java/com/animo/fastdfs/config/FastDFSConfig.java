package com.animo.fastdfs.config;

import com.animo.fastdfs.config.bean.FastDFSBean;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author 刘金泳
 * @Date 2019/11/1
 */
@Component
@Order(1)
public class FastDFSConfig implements ApplicationRunner {

    @Autowired
    private FastDFSBean fastDFSBean;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ClientGlobal.setG_connect_timeout(fastDFSBean.getConnectTimeoutInSeconds());
        ClientGlobal.setG_network_timeout(fastDFSBean.getNetworkTimeoutInSeconds());
        ClientGlobal.setG_charset(fastDFSBean.getCharset());
        try {
            ClientGlobal.initByTrackers(fastDFSBean.getTrackerServers());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        System.out.println("fastDFS配置成功");
    }
}
