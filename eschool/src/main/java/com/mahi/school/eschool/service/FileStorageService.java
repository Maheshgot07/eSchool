package com.mahi.school.eschool.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mahi.school.eschool.filestore.FileStorageException;
import com.mahi.school.eschool.filestore.FileStorageProperties;
import com.mahi.school.eschool.filestore.MyFileNotFoundException;

@Service
public class FileStorageService {
	private final Path fileStorageLocation;
	public String storeFile(MultipartFile file, String imageId) {
		 try {
			 if(file != null && imageId != null) {
			 System.out.println(imageId);
			             // Get the file and save it somewhere
			             byte[] bytes = file.getBytes();
			             Path path = Paths.get(fileStorageLocation + "//"+imageId);
			             
			             Files.write(path, bytes);
			 }

			         } catch (IOException e) {
			         	throw new
			    		  FileStorageException("Sorry! Filename contains invalid path sequence " +
			    				  imageId);
			         }
			         return imageId;
		
	}
	
	@Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
	
	public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }

}
