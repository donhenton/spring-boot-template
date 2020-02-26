 

package com.dhenton9000.spring.boot.okta;

 
 

/*

WebSecurityConfig
This class extends the WebSecurityConfigurerAdapter. This is a convenience class
that allows customization to both WebSecurity and HttpSecurity.


 */
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
 

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    private static final Logger LOG = LoggerFactory.getLogger(WebSecurityConfig.class);

 
    
    @Override
    protected void configure(final HttpSecurity http) throws Exception { 
        
        
   
        /****************************************************************/
        // this will only authenticate restricted stuff but will produce
        // a 404 if you fail
        // use @Preauthorize on the end point instead
        
            http
             .authorizeRequests()
                 .antMatchers("/restricted/*").authenticated()
                 .antMatchers("/**").permitAll() ;
            // .and().oauth2Login(); 
      
        /****************************************************************/
        // http.csrf().disable(); //needed to allow the jwt authentication endpoint
         
        /*
         
        http.csrf().disable().authorizeRequests().antMatchers("/").
        permitAll().and().exceptionHandling().
        authenticationEntryPoint(jwtAuthenticationEntryPoint).
        and().sessionManagement().
        sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
        // Add a filter to validate the tokens with every request
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
          */
    }  

    /*
    
    
         //   LOG.info("did sec");
//    http.antMatcher("/**")  
//            .authorizeRequests()  
//            .antMatchers("/").permitAll()  
//            .anyRequest().authenticated()
//            .and().formLogin();  
    
    
    
    
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
// We don't need CSRF for this example
        httpSecurity.csrf().disable()
                // dont authenticate this particular request
                .authorizeRequests().antMatchers("/authenticate").permitAll().
                
                // all other requests need to be authenticated
                anyRequest().authenticated().and().
                // make sure we use stateless session; session won't be used to
                // store user's state.
                exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// Add a filter to validate the tokens with every request
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
     */
}
