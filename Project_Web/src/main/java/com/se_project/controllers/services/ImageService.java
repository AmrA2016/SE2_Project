package com.se_project.controllers.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {
	
	private Path imagePath = Paths.get("src\\main\\resources\\static\\uploaded-images");
	
	public String storeImage(MultipartFile image ){
		try {
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String originalFile = image.getOriginalFilename();
			String imagename = originalFile.substring(0,originalFile.lastIndexOf('.'));
			String imagetype = originalFile.substring(originalFile.lastIndexOf('.'),originalFile.length());
			
			String editedFileName = imagename + "_" + timestamp.getTime() + imagetype;
			
            Files.copy(image.getInputStream(), this.imagePath.resolve(editedFileName));
            return editedFileName;
        } catch (Exception e) {
        	throw new RuntimeException("FAIL!");
        }
	}
	
	public void deleteImage(String imageName){
		try{
			Files.delete(imagePath.resolve(imageName));
		}catch (Exception e){
        	throw new RuntimeException("FAIL!");
		}
	}
}
