package info.ishans;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created with IntelliJ IDEA.
 * User: ishan
 * Date: 9/14/14
 * Time: 2:53 PM
 * To change this template use File | Settings | File Templates.
 */

@Controller
@RequestMapping("/admin")

public class AdminController {
    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        model.addAttribute("message", "Hello world!");
        return "helloadmin";
    }
}
