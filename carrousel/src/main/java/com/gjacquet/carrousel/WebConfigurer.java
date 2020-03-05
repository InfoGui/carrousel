package com.gjacquet.carrousel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import com.gjacquet.carrousel.properties.ApplicationProperties;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfigurer implements WebMvcConfigurer {

    @Autowired
    ApplicationProperties applicationProperties;

    @Override
    public void addResourceHandlers( ResourceHandlerRegistry registry ) {
        System.out.println( "Je charge le repertoire d'image : " + applicationProperties.getImages() );
        registry.addResourceHandler( "/images/**" ).addResourceLocations( "file:" + applicationProperties.getImages()
                        + "//" );

        System.out.println( "Je charge le repertoire de resources : " + applicationProperties.getDependances() );
        registry.addResourceHandler( "/dependances/**" ).addResourceLocations( "file:"
                        + applicationProperties.getDependances() + "//" );

    }

//    @Bean
//    @Description( "Localisation des templates" )
//    public ClassLoaderTemplateResolver templateResolver() {
//
//        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//        System.out.println( "Je charge le repertoire de templates : " + applicationProperties.getTemplates() );
//        templateResolver.setPrefix( "D:/carrousel/pack-carrousel/src/main/resources/ihm/templates/" );
//        templateResolver.setSuffix( ".html" );
//        templateResolver.setCacheable( false );
//        templateResolver.setTemplateMode( "HTML" );
//        templateResolver.setCharacterEncoding( "UTF-8" );
//
//        return templateResolver;
//    }
//
//    @Bean
//    @Description( "Thymeleaf template engine with Spring integration" )
//    public SpringTemplateEngine templateEngine() {
//
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver( templateResolver() );
//
//        return templateEngine;
//    }
//
//    @Bean
//    @Description( "Thymeleaf view resolver" )
//    public ViewResolver viewResolver() {
//
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//
//        viewResolver.setTemplateEngine( templateEngine() );
//        viewResolver.setCharacterEncoding( "UTF-8" );
//
//        return viewResolver;
//    }
}