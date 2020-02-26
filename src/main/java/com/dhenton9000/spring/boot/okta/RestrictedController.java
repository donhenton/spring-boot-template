 

package com.dhenton9000.spring.boot.okta;

 

import java.util.Map;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
    public String helloJWT(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
            @AuthenticationPrincipal OAuth2User oauth2User) {
        return "User Name: " + oauth2User.getName() + "<br/>"
                + "User Authorities: " + oauth2User.getAuthorities() + "<br/>"
                + "Client Name: " + authorizedClient.getClientRegistration().getClientName() + "<br/>"
                + this.prettyPrintAttributes(oauth2User.getAttributes());
    }

    private String prettyPrintAttributes(Map<String, Object> attributes) {
        String acc = "User Attributes: <br/><div style='padding-left:20px'>";
        for (String key : attributes.keySet()) {
            Object value = attributes.get(key);
            acc += "<div>" + key + ":&nbsp" + value.toString() + "</div>";
        }
        return acc + "</div>";
    }
}
