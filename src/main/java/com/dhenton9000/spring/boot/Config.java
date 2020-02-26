 
package com.dhenton9000.spring.boot;

import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

 
 @Configuration
public class Config {

    
    private static final Logger LOG = LoggerFactory.getLogger(Config.class);

    public Config() {
        
       
    }
    
    
    @Bean
    public HashMap<String,String> getProps() {
       HashMap<String,String> h = new HashMap<>();
      
        return h;
    }
    
    
    
    
}
