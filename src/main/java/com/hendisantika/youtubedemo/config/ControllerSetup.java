package com.hendisantika.youtubedemo.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
/**
 * Created by IntelliJ IDEA.
 * Project : candidate-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/11/17
 * Time: 04.12
 * To change this template use File | Settings | File Templates.
 * This class trims leading and trailing whitespace from text field entries
 */


@ControllerAdvice
public class ControllerSetup {
	
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(String.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                if (text == null) {
                    return;
                }
    	        
                setValue(text.trim());
            }
    
    	    
            @Override
            public String getAsText() {
                Object value = getValue();
                return (value != null ? value.toString().trim() : "");		        
            }
        });
    }
}
