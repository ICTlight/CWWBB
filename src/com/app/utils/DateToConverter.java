package com.app.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.convert.converter.Converter;
/**
 * @ file_name DateConverter.java
 * @ author LiuTuo
 * @ description
 * @ reviewed_by 
 */
public class DateToConverter implements Converter<String, Date>{
	protected transient final Log log = LogFactory.getLog(DateToConverter.class);
	
    public Date convert(String text) {
    	log.debug(text);
    	if (text == null || "".equals(text)) {
            return null;
        }
        Date date = tryConvert(text, "yyyy-MM-dd");
        if (date != null) {
            return new java.sql.Date(date.getTime());
        }
        return null;
        
    }

    public Date tryConvert(String text, String pattern) {
    	SimpleDateFormat formatDate = new SimpleDateFormat(pattern);
        //dateFormat.setLenient(false);
        try {
        	java.sql.Date date = new java.sql.Date(formatDate.parse(text).getTime());
            return date ;
        } catch (ParseException ex) {
        	log.error("Error occurred when tryConvert methods of DateConverter.");
        	ex.printStackTrace();
        	return null;
        }
       
    }
}
