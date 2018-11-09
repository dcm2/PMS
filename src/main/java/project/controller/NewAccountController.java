package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.User;
import project.service.LandingService;

@Controller
public class NewAccountController {

	// Instance variables
	private LandingService landingService;
	
	// Dependency injection
	@Autowired
	public NewAccountController(LandingService landingService) {
		this.landingService = landingService;
	}
	
	/* DISPLAYS NewAccount PAGE (view if the url localhost:8080/newAccount)
	 * RequestMapping maps the method newAccountView with the path url/newAccount, so:
	 * whenever "localhost:8080/newAccount" is typed in the browser, this method is called 
	 */	
	
    @RequestMapping(value="/newAccount", method=RequestMethod.GET)
    public String newAccountView(Model model) {
    	
    	// Adds an attribute to the model with name newUserInfo
    	model.addAttribute("newUserInfo",new User());
    	
		return "NewAccount";
    }
    
	/* THIS MANAGES THE SIGN UP form (the one used to register a new account)
	 * signUpPost receives the POST request on the url/home, and receives the ModelAttribute: newUserInfo
	 * the attribute newUserInfo is the attribute that is mapped to the SIGN UP form (see: NewAccount.jsp)
	 */ 

    @RequestMapping(value="/playlist", method=RequestMethod.POST)
    public String signUpPost(@ModelAttribute("newUserInfo") User newUserInfo, Model model) {
    	
    	// saves the User from newUserInfo in the db 
		landingService.save(newUserInfo);
		
    	return "Playlist"; 	
    }
}