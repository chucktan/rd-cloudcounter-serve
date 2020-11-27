package com.rd.cloudcounter.resource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author
 * @create 2020-11-27-14:09
 */
@Component
@ConfigurationProperties(prefix = "file")//前缀
@PropertySource("classpath:file-upload-dev.properties")
public class FileUpload {

    private  String imageManagerFaceLocation;
    private  String imageServerUrl;

    public String getImageManagerFaceLocation() {
        return imageManagerFaceLocation;
    }

    public void setImageManagerFaceLocation(String imageManagerFaceLocation) {
        this.imageManagerFaceLocation = imageManagerFaceLocation;
    }

    public String getImageServerUrl() {
        return imageServerUrl;
    }

    public void setImageServerUrl(String imageServerUrl) {
        this.imageServerUrl = imageServerUrl;
    }
}
