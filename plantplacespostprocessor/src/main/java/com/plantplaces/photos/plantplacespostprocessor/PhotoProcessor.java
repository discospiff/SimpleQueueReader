package com.plantplaces.photos.plantplacespostprocessor;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class PhotoProcessor {

	@JmsListener(destination="photos")
	public void processPhoto(String path) {
		System.out.println("Path is: " + path);
		int i = 1 + 1;
	}
	
}
