package com.nito.fantasy.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Formatter {
    
    public static String formatNumber(Integer value) {    	
    	DecimalFormat formatter = new DecimalFormat( "#,###,###,###" );
        String aux = null;
    	try {
        	if(value != null && !"".equals(value)) {
            	aux = formatter.format(value);    		
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return aux;
    }
    
    public static Date parseDate(String value) {    	
    	SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault());
    	Date aux = null;
    	try {
        	if(value != null && !"".equals(value)) {
            	aux = df.parse(value);    		
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return aux;
    }
    
    public static String formatDate(String value) {    	
    	SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssX", Locale.getDefault());
    	SimpleDateFormat df2 = new SimpleDateFormat( "dd/MM/yyyy HH:mm", Locale.getDefault());
    	String aux = null;
    	try {
        	if(value != null && !"".equals(value)) {
            	aux = df2.format(df.parse(value));
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        return aux;
    }
}
