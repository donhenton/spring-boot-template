 

package com.dhenton9000.spring.boot.okta;

 

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/restricted")
@PreAuthorize("isAuthenticated()") // yields a 500 with AccessDeniedException
public class RestrictedController {

//    @ResponseBody
//    @RequestMapping(value = "/hellojwt", method = RequestMethod.GET)
//    public String helloJWT(OAuth2Authentication auth, @RequestHeader (name="Authorization") String  token) {
//        return "hello";
//    }
    @ResponseBody
    @RequestMapping(value = "/hellojwt", method = RequestMethod.GET)
    public String helloJWT(OAuth2Authentication auth, @RequestHeader (name="Authorization") String  token) {
        return "hello";
    }
}
