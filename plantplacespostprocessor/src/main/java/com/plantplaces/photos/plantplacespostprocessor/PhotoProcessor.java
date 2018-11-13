package com.plantplaces.photos.plantplacespostprocessor;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;

@Component
public class PhotoProcessor {

	@JmsListener(destination="photos")
	public void processPhoto(String path) {
		System.out.println("Path is: " + path);
		File file = new File(path);
		Path photoPath = Paths.get(path).getParent();
		Path fileName = Paths.get(path).getFileName();
		String thumbnailFullPath = photoPath + File.separator + "thumbnail" + File.separator + fileName;
		File thumbnailFile = new File(thumbnailFullPath);
		String watermarkPath = photoPath + File.separator + "watermark.png";
		File watermarkFile = new File(watermarkPath);
		
		try {
			BufferedImage watermark = ImageIO.read(watermarkFile);
			Thumbnails.of(file).scale(1).watermark(Positions.BOTTOM_RIGHT, watermark, 0.9f).toFile(file);
			Thumbnails.of(file).size(100, 100).toFile(thumbnailFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
