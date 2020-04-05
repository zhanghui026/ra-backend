package com.zh.raback.web.rest.dto;

import lombok.Data;

@Data
public class PictureDTO {

    private String title;

    /**
     * base64 enc
     */
    private String src;


}
