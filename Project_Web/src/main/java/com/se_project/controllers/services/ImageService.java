package com.se_project.controllers.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Handling the operations of saving and deleting the images in the server
 *
 */
@Service
public class ImageService {
	
	/**
	 * The root path that will contains the uploaded images
	 * <p>
	 * This path starts at the root of the application not the root of the device
	 */
	private Path imagePath = Paths.get("src\\main\\resources\\static\\uploaded-images");
	
	/**
	 * Store or upload the image to the server 
	 * by making a copy of the image and saves it in a imagePath directory so can accessed by the application easily
	 * <p>
	 * It edits the image file name by adding the current timestamp to the name to make image unique
	 * and handles the duplication in image names
	 * @param image the image file to be saved
	 * @return the name of the image stored after editing
	 */
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
	
	/**
	 * Delete the image from imagePath directory
	 * @param imageName the image name to be deleted
	 */
	public void deleteImage(String imageName){
		try{
			Files.delete(imagePath.resolve(imageName));
		}catch (Exception e){
        	throw new RuntimeException("FAIL!");
		}
	}
}
