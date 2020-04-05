package com.zh.raback.web.rest;

import com.zh.raback.config.ApplicationProperties;
import com.zh.raback.service.FileManagerService;
import com.zh.raback.service.StorageService;
import com.zh.raback.service.dto.BizCodeEnum;
import com.zh.raback.service.dto.FileManagerDTO;
import com.zh.raback.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Paths;
import java.util.Optional;


/**
 * 上传Controller
 */
@RestController
@RequestMapping("/api/upload")
@Api(description = "上传接口，所有的图片上传、附件上传接口", tags = "文件上传汇总接口")
public class UploadFileResource {

    private static final String ENTITY_NAME = "painting";
    private final Logger log = LoggerFactory.getLogger(UploadFileResource.class);


    @Autowired
    private StorageService storageService;

    @Autowired
    private FileManagerService fileManagerService;

    @Autowired
    private ApplicationProperties applicationProperties;

    @PostMapping("/{bizCode}")
    @ApiOperation(value = "上传图", notes = "上传图", response = FileManagerDTO.class)
    public ResponseEntity<FileManagerDTO> uploadAuthorPortrait(@RequestParam("file") MultipartFile file, @PathVariable String bizCode) throws IOException {
        try {
            BizCodeEnum.valueOf(bizCode);
        }catch (Exception e){
            throw new BadRequestAlertException("此方式不支持","bizcodeupload","bizcodeupload");
        }


        FileManagerDTO fileManagerDTO = this.commonUpload(file, bizCode);


        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(fileManagerDTO));
    }


    /**
     * 1. 保存文件到服务器
     * 2. 保存文件信息到文件管理表
     */

    private FileManagerDTO commonUpload(MultipartFile file, String bizCode) throws IOException {
        FileManagerDTO fileManagerDTO;
        fileManagerDTO = storageService.store(file, bizCode);
        fileManagerDTO.setBizCode(bizCode);

        String http = applicationProperties.getNginxBase()+"/"+bizCode+"/"+ URLEncoder.encode(fileManagerDTO.getDefaultFileName(),"utf-8");
        fileManagerDTO.setDefaultUrl(http);
        FileManagerDTO save = this.fileManagerService.save(fileManagerDTO);
        return save;

    }

    /**
     * 1. 删除服务器文件
     * 2. 删除文件管理表信息
     */
    private void commonDelete(Long fileId) throws IOException {
        Optional<FileManagerDTO> fileOptional = this.fileManagerService.findOne(fileId);
        if (fileOptional.isPresent()) {
            FileManagerDTO file = fileOptional.get();
            this.storageService.deleteFile(Paths.get(file.getDefaultPath()), file.getDefaultFileName());
            this.fileManagerService.delete(fileId);
        }

    }

}
