package com.gx.core.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.convert.converter.Converter;

public class LongConverter implements Converter<String, Long> {
    private static Logger logger = LoggerFactory.getLogger(LongConverter.class);
  //  private List<String> patterns = new ArrayList<String>();

    public LongConverter() {

    }

    public Long convert(String text) {
        if (text == null) {
            return null;
        }

        Long date = tryConvert(text);

        if (date != null) {
            return date;
        }
       
        return null;
    }

    public Long tryConvert(String text) {


        try {
            return Long.parseLong(text);
        } catch (Exception ex) {
            logger.debug(ex.getMessage(), ex);
        }

        return null;
    }

}
