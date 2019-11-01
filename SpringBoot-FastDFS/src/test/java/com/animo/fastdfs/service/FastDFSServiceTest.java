package com.animo.fastdfs.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FastDFSServiceTest {

    /**
     * 测试结果看控制台输出 方法内部已打印
     */

    @Autowired
    private FastDFSService fastDFSService;

    @Test
    void uploadTest() {
        //文件全路径
        String local_filename = "/Users/liujinyong/Downloads/29E8D39D-4AA6-4D34-AC66-44F8943B7514.png";
        //文件后缀
        String file_ext_name = "png";
        fastDFSService.uploadTest(local_filename,file_ext_name,null);
    }

    @Test
    void download() {
        //文件ID
        String fileId = "group1/xx/xx/xxx/xxxxxxxxx.png";
        //需要保存到什么路径 这里是全路径报错文件名称虽然没有但是会输出到这个文件下。
        String pathUrl = "/Users/liujinyong/Downloads/xxx.png";
        fastDFSService.download(fileId,pathUrl);
    }

    @Test
    void delete() {
        //文件ID
        String fileId = "group1/xx/xx/xxx/xxxxxxxxx.png";
        fastDFSService.delete(fileId);
    }
}