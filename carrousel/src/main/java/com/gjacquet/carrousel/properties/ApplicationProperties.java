package com.gjacquet.carrousel.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties( "spring.application" )
public class ApplicationProperties {

    private String images;

    private String dependances;

    private String templates;

    @Override
    public String toString() {
        return "ApplicationProperties [images=" + images + ", dependances=" + dependances + ", templates=" + templates
                        + "]";
    }

    public String getImages() {
        return images;
    }

    public void setImages( String images ) {
        this.images = images;
    }

    public String getDependances() {
        return dependances;
    }

    public void setDependances( String dependances ) {
        this.dependances = dependances;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates( String templates ) {
        this.templates = templates;
    }

}
