package com.gjacquet.carrousel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gjacquet.carrousel.properties.ApplicationProperties;
import com.gjacquet.carrousel.utils.FileUtils;

@Controller
public class FrontController {

	@Autowired
	ApplicationProperties applicationProperties;

	FileUtils fileUtils = new FileUtils();

	@GetMapping("/")
	public String homePage(final Model model) {

		String chemin = applicationProperties.getImages();
		List<File> fichiers = new ArrayList<>();
		List<String> iframes = new ArrayList<>();
		File repertoire = new File(chemin);
		if (repertoire.isDirectory()) {
			fichiers = fileUtils.getImages(repertoire);
			iframes = fileUtils.getIframes(repertoire);
		}
		
		model.addAttribute("fichiers", fichiers);
		model.addAttribute("iframes", iframes);

		return "home.html";
	}

}