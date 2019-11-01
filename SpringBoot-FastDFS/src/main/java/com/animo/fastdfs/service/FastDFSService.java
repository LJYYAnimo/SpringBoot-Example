package com.animo.fastdfs.service;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author 刘金泳
 * @Date 2019/11/1
 */
@Service
public class FastDFSService {

    /**
     * 文件上传
     * @param file 前端文件
     * @return
     */
    public String upload(MultipartFile file){
        StorageClient1 storageClient1 = getStorageClient1();
        try {
            //文件字节
            byte[] bytes = file.getBytes();
            //文件原始名称
            String originalFilename = file.getOriginalFilename();
            //获取扩展名称
            String file_ext_name = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            String fileId = storageClient1.upload_file1(bytes,file_ext_name,null);
            System.out.println("文件ID:"+fileId);
            return fileId;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 测试类专用
     * @param local_filename 文件全路径
     * @param file_ext_name 文件扩展名
     * @param meta_list 源文件信息 可以为Null
     * @return
     */
    public String uploadTest(String local_filename, String file_ext_name, NameValuePair[] meta_list){
        StorageClient1 storageClient1 = getStorageClient1();
        try {
            String fileId = storageClient1.upload_file1(local_filename, file_ext_name, meta_list);
            System.out.println("文件ID:"+fileId);
            return fileId;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 文件下载
     * @param fileId 文件ID
     * @param pathUrl 需要下载到哪个路径
     */
    public void download(String fileId,String pathUrl){
        StorageClient1 storageClient1 = getStorageClient1();
        FileOutputStream fileOutputStream = null;
        try {
            byte[] bytes = storageClient1.download_file1(fileId);
            fileOutputStream = new FileOutputStream(new File(pathUrl));
            fileOutputStream.write(bytes);
            System.out.println("写入成功，文件路径:"+pathUrl);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除文件
     * @param fileId 文件ID
     */
    public void delete(String fileId){
        StorageClient1 storageClient1 = getStorageClient1();
        try {
            int result = storageClient1.delete_file1(fileId);
            System.out.println("删除结果反馈:"+result);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 最终操作都基于StorageClient1 所以封装获取StorageClient1的方法
     * @return
     */
    private StorageClient1 getStorageClient1(){
        try {
            //创建Tracker客户端
            TrackerClient trackerClient = new TrackerClient();
            //获取Tracker服务端
            TrackerServer trackerServer = trackerClient.getConnection();
            //创建Storage服务端
            StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
            //创建Storage客户端
            StorageClient1 storageClient1 = new StorageClient1(trackerServer,storageServer);
            return storageClient1;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("链接出错");
        }
        return null;
    }

}
