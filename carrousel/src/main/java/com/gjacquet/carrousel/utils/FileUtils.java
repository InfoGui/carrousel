package com.gjacquet.carrousel.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.stereotype.Service;

@Service
public class FileUtils {

	public List<File> getImages(File repertoire) {
		List<File> fichiers = Arrays.asList(repertoire.listFiles());
		Collections.sort(fichiers);

		List<File> images = new ArrayList<>();
		for (File fichier : repertoire.listFiles()) {
			if (!fichier.isDirectory() && isImage(fichier)) {
				images.add(fichier);
			}
		}

		return images;
	}

	public List<String> getIframes(File repertoire) {
		List<File> fichiers = Arrays.asList(repertoire.listFiles());
		Collections.sort(fichiers);

		List<String> iframes = new ArrayList<>();
		for (File fichier : fichiers) {
			if (!fichier.isDirectory() && isIframe(fichier)) {
				StringBuilder contentBuilder = new StringBuilder();
				try (Stream<String> stream = Files.lines(Paths.get(fichier.getAbsolutePath()),
						StandardCharsets.UTF_8)) {
					stream.forEach(s -> contentBuilder.append(s));
				} catch (IOException e) {
					e.printStackTrace();
				}
				iframes.add(contentBuilder.toString());
			}
		}

		return iframes;
	}

	public boolean isImage(File fichier) {
		String mimeType = new MimetypesFileTypeMap().getContentType(fichier);
		String type = mimeType.split("/")[0];
		return fichier.exists() && type.equals("image");
	}

	public boolean isIframe(File fichier) {
		String name = fichier.getName();
		String[] parts = name.split("\\.");
		return fichier.exists() && parts.length > 1 && parts[1].equals("iframe");
	}
}
