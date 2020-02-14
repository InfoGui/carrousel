package com.carrousel.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author gjacquet
 *
 */
public class LogUtils {

    private LogUtils() {
    }

    /**
     * 
     * @param message
     */
    public static void logInfo( final String message ) {
        LogUtils.log( Level.INFO, message );
    }

    /**
     * 
     * @param message
     */
    public static void logSevere( final String message ) {
        LogUtils.log( Level.SEVERE, message );
    }

    /**
     * 
     * @param level
     * @param message
     */
    private static void log( final Level level, final String message ) {
        final Logger logger = Logger.getLogger( "logger" );
        logger.log( level, message );
    }

}
