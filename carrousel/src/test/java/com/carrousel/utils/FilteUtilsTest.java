package com.carrousel.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.carrousel.properties.ApplicationProperties;

@SpringBootTest
public class FilteUtilsTest {

	@Autowired
	FileUtils fileUtils;

	@Autowired
	ApplicationProperties applicationProperties;

	@DisplayName("getImagesTest")
	@Test
	public void getImagesTest() {
		File repertoire = new File(applicationProperties.getImages());
		List<File> images = fileUtils.getImages(repertoire);

		assertEquals(2, images.size());
		assertEquals("image1.png", images.get(0).getName());
	}

	@DisplayName("getIframesTest")
	@Test
	public void getIframesTest() {
		File repertoire = new File(applicationProperties.getImages());
		List<String> urls = fileUtils.getIframes(repertoire);

		assertEquals(2, urls.size());
		assertEquals("http://localhost:8081", urls.get(1));
	}

}
