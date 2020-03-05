package com.gjacquet.carrousel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
		File source = new File(chemin);
		if (source.isDirectory()) {
			fichiers = fileUtils.getImages(source);
			iframes = fileUtils.getIframes(source);
		}

		model.addAttribute("repertoire", "");
		model.addAttribute("fichiers", fichiers);
		model.addAttribute("iframes", iframes);

		return "home.html";
	}

	@GetMapping("/{repertoire}")
	public String repertoirePage(final Model model, @PathVariable final String repertoire) {

		String chemin = applicationProperties.getImages() + repertoire;
		List<File> fichiers = new ArrayList<>();
		List<String> iframes = new ArrayList<>();
		File source = new File(chemin);
		if (source.isDirectory()) {
			fichiers = fileUtils.getImages(source);
			iframes = fileUtils.getIframes(source);
		}

		model.addAttribute("repertoire", repertoire);
		model.addAttribute("fichiers", fichiers);
		model.addAttribute("iframes", iframes);

		return "home.html";
	}

}