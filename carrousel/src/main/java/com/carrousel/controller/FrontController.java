package com.carrousel.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carrousel.properties.ApplicationProperties;

@Controller
public class FrontController {

	@Autowired
	ApplicationProperties applicationProperties;

	@GetMapping("/")
	public String homePage(final Model model) {

		String chemin = applicationProperties.getImages();
		List<File> fichiers = new ArrayList<>();
		File repertoire = new File(chemin);
		if (repertoire.isDirectory()) {
			fichiers = choisirFichiers(repertoire);
		}

		model.addAttribute("chemin", chemin);
		model.addAttribute("fichiers", fichiers);

		return "home.html";
	}

	private List<File> choisirFichiers(File repertoire) {
		List<File> fichiers = new ArrayList<>();
		for (File fichier : repertoire.listFiles()) {
			if (!fichier.isDirectory() && isImage(fichier)) {
				fichiers.add(fichier);
			}
		}

		return fichiers;
	}

	private boolean isImage(File fichier) {
		String mimeType = new MimetypesFileTypeMap().getContentType(fichier);
		String type = mimeType.split("/")[0];
		return type.equals("image");
	}

}