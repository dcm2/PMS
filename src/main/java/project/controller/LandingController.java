package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LandingController {
	
    // Request mapping is the path that you want to map this method to
    // In this case, the mapping is the root "/", so when the project
    // is running and you enter "localhost:8080" into a browser, this
    // method is called
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String land(){

        // The string "Landing" that is returned here is the name of the view
        // (the Landing.jsp file) that is in the path /main/webapp/WEB-INF/jsp/
        return "Landing";
    }
    
    // To call this method, enter "localhost:8080/home" into a browser
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Model model) {
    		
    		return "Home";
    }
    

}