package info.ishans.cseanalyzer.controllers;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 11:43 AM
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class LoginController {
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(ModelMap model,
                               @RequestParam(value = "success", required = false) String success
                             )
    {

        if(success !=null){
            Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>)
                    SecurityContextHolder.getContext().getAuthentication().getAuthorities();

            //if this is an admin
            if(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))){
                return "redirect:admin";
            }
            else if(authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))){
                return "redirect:app";
            }

        }

        model.addAttribute("message", "Hello world!");
        return "login";
    }

    @RequestMapping(value = "/accessdenied",method = RequestMethod.GET)
    public String accessDenied(ModelMap model)
    {
        return "403";
    }
}
