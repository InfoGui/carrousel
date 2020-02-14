package com.carrousel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication( scanBasePackages = { "controller", "utils", "properties", "com.carrousel" } )
public class Carrousel {

    public static void main( final String[] args ) {
        SpringApplication.run( Carrousel.class, args );
    }
}
