package com.mahi.school.eschool.filestore;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "file")
@Configuration
public class FileStorageProperties {
    private String uploadDir;

    public String getUploadDir() {
    	System.out.println("Path is: "+uploadDir);
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }
}
