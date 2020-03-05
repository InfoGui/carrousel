package com.gjacquet.carrousel.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gjacquet.carrousel.properties.ApplicationProperties;
import com.gjacquet.carrousel.utils.FileUtils;

@SpringBootTest
public class FilteUtilsTest {

	@Autowired
	FileUtils fileUtils;

	@Autowired
	ApplicationProperties applicationProperties;

	@Tag("dao")
	@DisplayName("getImagesTest")
	@Test
	public void getImagesTest() {
		File repertoire = new File(applicationProperties.getImages());
		List<File> images = fileUtils.getImages(repertoire);
		
		assertEquals(2, images.size());
		assertEquals("image1.jpg", images.get(0).getName());
	}

	@Tag("algo")
	@DisplayName("getIframesTest")
	@Test
	public void getIframesTest() {
		File repertoire = new File(applicationProperties.getImages());
		List<String> urls = fileUtils.getIframes(repertoire);

		assertEquals(2, urls.size());
		assertTrue(urls.contains("http://localhost:8081"));
		assertTrue(urls.contains("https://www.baeldung.com/java-file-extension"));
	}

}
