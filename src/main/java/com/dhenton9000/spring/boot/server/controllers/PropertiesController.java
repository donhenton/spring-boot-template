/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this TEMPLATE file, choose Tools | Templates
 * and open the TEMPLATE in the editor.
 */
package com.dhenton9000.spring.boot.server.controllers;

 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.util.Enumeration;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/props")
@CrossOrigin
public class PropertiesController {

 
    private final ResourceBundle applicationProps = ResourceBundle.getBundle("app");
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesController.class);
    @Value("${test.prop}")
    private String testValue;
    private  final  String allProperties;
    
    
    
    public PropertiesController() {
        
        String tempString = "";
        Enumeration<String> keyenum = applicationProps.getKeys();
        while (keyenum.hasMoreElements())
        {
            String k = keyenum.nextElement();
            String value = applicationProps.getString(k);
            tempString += k+"="+value+"\n";
             
        }
        this.allProperties = tempString;
    }
    
    
    
    

    
    
    @ApiOperation(value = "getSingleProperty", nickname = "getSingleProperty")
    @RequestMapping( method = RequestMethod.GET, path = "/property", produces= "text/plain"  )
    @ApiImplicitParams({
        @ApiImplicitParam(name = "propName", value = "Requested Property", required = true, dataType = "string", paramType = "query")
    })
    public String getSingleProperty(@RequestParam(value = "propName") String propName)
    {
        String foundProp = null;
        
        try {
           foundProp =    applicationProps.getString(propName);
        }
        catch (Throwable t)
        {
            
        }
        
        return foundProp;
           
    }
    
    @ApiOperation(value = "getAllProperties", nickname = "getAllProperties")
    @RequestMapping( method = RequestMethod.GET, path = "/all/properties",produces= "text/plain" )
    
    public String getAllProperties()
    {
          //LOG.info("all properites "+this.allProperties);
          return this.allProperties;
    }

    
}

  