/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dhenton9000.spring.boot.server.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dhenton
 */


@Controller
public class MainController {
    
//    @RequestMapping("/")
//    public String homePageToSwagger() {
//        
//      
//        return "redirect:swagger-ui.html";
//    }
    
    
    @RequestMapping("/")
    public String homePageToSwagger() {
        
      
        return "pages/home";
    }
    
    
}


 

