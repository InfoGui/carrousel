package com.carrousel.controller;

import java.io.File;
import java.io.FileFilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.carrousel.properties.ApplicationProperties;

@Controller
public class FrontController {

    @Autowired
    ApplicationProperties applicationProperties;

    @GetMapping( "/" )
    public String homePage( final Model model ) throws InterruptedException {

        String chemin = applicationProperties.getImages();
        File[] fichiers = {};
        File repertoire = new File( chemin );
        if ( repertoire.isDirectory() ) {
            fichiers = repertoire.listFiles();
        }

        model.addAttribute( "chemin", chemin );
        model.addAttribute( "fichiers", fichiers );

        return "home.html";
    }

}