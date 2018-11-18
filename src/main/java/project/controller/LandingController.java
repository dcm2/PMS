package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.beans.UserInfo;
import project.persistence.entities.User;
import project.service.LandingService;


@Controller
public class LandingController {
	
	// Instance variables
	private LandingService landingService;
	
	// Dependency injection
	@Autowired
	public LandingController(LandingService landingService) {
		this.landingService = landingService;
	}
	
	/* DISPLAYS Landing PAGE (view of the url localhost:8080)
	 * Request mapping is the path that you want to map this method to. In this case mapping is the root "/" so:
	 * whenever "localhost:8080" is typed in the browser, this method is called
	 */ 	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String landingView(Model model){ 
			
		// Adds an attribute to the model with name userInfo
    	model.addAttribute("userInfo", new UserInfo());
    	
        return "Landing";
    }
 
	/* THIS MANAGES THE LOG IN FORM (the one used when an account has already been created before)
	 * logInPost receives the POST request on the url/home, and receives the ModelAttribute: userInfo
	 * the attribute userInfo is the attribute that is mapped to the LOG IN form (see: Landing.jsp)
	 */ 

    @RequestMapping(value= "/userPage", method=RequestMethod.POST)
    public String logInPost(@ModelAttribute("userInfo") User userInfo, Model model) {

    	// methods to implement
    	String name = userInfo.getUserName();
    	System.out.println("The name to check is: " + name);
    	
    	System.out.println(landingService.isUserInDB(name));
    	
    	return "UserPage"; 	
    } 
   
    
}