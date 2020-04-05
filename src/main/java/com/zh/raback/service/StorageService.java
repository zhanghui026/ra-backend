package com.zh.raback.service;


import com.zh.raback.service.dto.FileManagerDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;


/**
 * 存储
 */
public interface StorageService {



    /**
     * 存储文件
     * @param file  文件
     * @Param path  路径
     * @param fileName 文件名
     */
    void store(MultipartFile file, Path path, String fileName) throws IOException;


    /**
     * 删除文件
     * @param path 文件路径
     * @param fileName 文件名字
     */
    void deleteFile(Path path, String fileName) throws IOException;

    /**
     * 移动文件，覆盖替换
     * @param source 源文件路径
     * @param target 目标文件路径
     * @throws IOException
     */
    void moveFile(Path source, Path target) throws IOException;

    /**
     * 根据业务编码将文件保存到对应目录下
     * @param file 文件
     * @param bizCode 业务模块
     * @Return fileManagerDTO 返回文件信息
     * @throws IOException
     */
    FileManagerDTO store(MultipartFile file, String bizCode) throws IOException;
}
