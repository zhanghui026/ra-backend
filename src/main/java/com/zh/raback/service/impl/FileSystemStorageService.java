package com.zh.raback.service.impl;


import com.zh.raback.config.ApplicationProperties;
import com.zh.raback.service.StorageService;
import com.zh.raback.service.dto.FileManagerDTO;
import com.zh.raback.web.rest.errors.StorageException;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 文件存储类
 *
 */
@Service
public class FileSystemStorageService implements StorageService {

    private static final Logger log = LoggerFactory.getLogger(FileSystemStorageService.class);

    @Autowired
    private ApplicationProperties applicationProperties;


    /**
     * 存储文件的方法
     * @param file  文件
     * @param path
     * @param fileName 文件名
     * @throws IOException 存储文件失败时抛出异常
     */
    @Override
    public void store(MultipartFile file, Path path, String fileName) throws IOException {
        try {
            if (file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + fileName);
            }
            if (fileName.contains("..")) {
                // This is a security check
                throw new StorageException(
                    "Cannot store file with relative path outside current directory "
                        + fileName);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, path.resolve(fileName),
                    StandardCopyOption.REPLACE_EXISTING);
            }
        }
        catch (IOException e) {
            throw new StorageException("Failed to store file " + fileName, e);
        }
    }


    /**
     * 删除文件
     * @param path 文件路径
     * @param fileName 文件名字
     * @throws IOException
     */
    @Override
    public void deleteFile(Path path, String fileName) throws IOException {
        Files.delete(path.resolve(fileName));
    }


    /**
     * 移动文件
     * @param source 源文件路径
     * @param target 目标文件路径
     * @throws IOException 异常
     */
    @Override
    public void moveFile(Path source, Path target) throws IOException {
        Files.move(source,target, StandardCopyOption.REPLACE_EXISTING);
    }


    @Override
    public FileManagerDTO store(MultipartFile file, String bizCode) throws IOException {

        FileManagerDTO fileManagerDTO = new FileManagerDTO();

        //生成独一无二的名字 file的名字 + 时间参数
        long now = System.currentTimeMillis();

        String fileName = FilenameUtils.getBaseName(file.getOriginalFilename())+"_"+ now + FilenameUtils.EXTENSION_SEPARATOR + FilenameUtils.getExtension(file.getOriginalFilename());

        log.debug("Upload fileName = {}",fileName);
        //storage为默认路径
        String pathStr = applicationProperties.getStorage() + File.separator + bizCode;

        File pathFile = new File(pathStr);
        if(!pathFile.exists()) {
            pathFile.mkdir();
        }

        Path path = Paths.get(pathStr);

        this.store(file,path,fileName);

        fileManagerDTO.setFileNo(now + "");
        fileManagerDTO.setDefaultFileName(fileName);
        fileManagerDTO.setDefaultPath(pathStr);
        fileManagerDTO.setIsCommit(false);


        return fileManagerDTO;
    }

}
