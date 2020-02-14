package com.carrousel.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    public static final String FORMATDATEEN = "yyyy-MM-dd HH:mm:ss";

    static final String FORMATDATEFR = "dd/MM/yyyy HH:mm:ss";

    static final TimeZone TIMEZONE = TimeZone.getTimeZone( "Europe/Paris" );

    private DateUtils() {
    }

    public static Date getDateFromStringFr( final String str ) {
        return getDateFromString( str, FORMATDATEFR );
    }

    public static Date getDateFromStringEn( final String str ) {
        return getDateFromString( str, FORMATDATEEN );
    }

    public static Date getDateFromString( final String str, final String format ) {
        final SimpleDateFormat sdf = new SimpleDateFormat( format );
        Date date = null;
        try {
            date = sdf.parse( str );
        } catch ( final ParseException e ) {
            LogUtils.logSevere( e.getMessage() );
        }

        return date;
    }

    public static Date getDuree( final Date dateDebut, final Date dateFin ) {
        long difference = 0;
        if ( dateFin != null && dateDebut != null ) {
            difference = Math.abs( dateFin.getTime() - dateDebut.getTime() );
        } else if ( dateFin == null && dateDebut != null ) {
            final Date now = new Date();
            difference = Math.abs( now.getTime() - dateDebut.getTime() );
        }

        return new Date( difference );
    }

    public static String getDateFormatee( final Date date ) {
        return getDateFormatee( date, FORMATDATEFR );
    }

    public static String getDateFormatee( final Date date, final String format ) {
        return getDateFormatee( date, format, TIMEZONE );
    }

    public static String getDateFormatee( final Date date, final String format, final TimeZone timezone ) {
        final SimpleDateFormat sdf = new SimpleDateFormat( format );
        sdf.setTimeZone( timezone );

        return sdf.format( date );
    }

    public static float getNombreHeure( final Date date ) {
        return ( float ) date.getTime() / 1000 / 3600;
    }

}
