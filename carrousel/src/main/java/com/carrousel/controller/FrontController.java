package com.carrousel.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
		List<String> iframes = new ArrayList<>();
		File repertoire = new File(chemin);
		if (repertoire.isDirectory()) {
			fichiers = choisirFichiers(repertoire);
			iframes = choisirIframes(repertoire);
		}

		model.addAttribute("chemin", chemin);
		model.addAttribute("fichiers", fichiers);
		model.addAttribute("iframes", iframes);

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

	private List<String> choisirIframes(File repertoire) {
		List<String> iframes = new ArrayList<>();
		for (File fichier : repertoire.listFiles()) {
			if (!fichier.isDirectory() && isIframe(fichier)) {
				StringBuilder contentBuilder = new StringBuilder();
				try (Stream<String> stream = Files.lines(Paths.get(fichier.getAbsolutePath()),
						StandardCharsets.UTF_8)) {
					stream.forEach(s -> contentBuilder.append(s).append("\n"));
				} catch (IOException e) {
					e.printStackTrace();
				}
				iframes.add(contentBuilder.toString());
			}
		}

		return iframes;
	}

	private boolean isImage(File fichier) {
		String mimeType = new MimetypesFileTypeMap().getContentType(fichier);
		String type = mimeType.split("/")[0];
		return type.equals("image");
	}

	private boolean isIframe(File fichier) {
		String name = fichier.getName();
		String[] parts = name.split("\\.");

		return parts.length > 1 && parts[1].equals("iframe");
	}

}