package project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import project.persistence.entities.Playlist;
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
    	model.addAttribute("newUserInfo", new User());
    	
		return "NewAccount";
    }
    
	/* THIS MANAGES THE SIGN UP form (the one used to register a new account)
	 * signUpPost receives the POST request on the url/home, and receives the ModelAttribute: newUserInfo
	 * the attribute newUserInfo is the attribute that is mapped to the SIGN UP form (see: NewAccount.jsp)
	 */ 

    @RequestMapping(value="/newAccount", method=RequestMethod.POST)
    public String signUpPost(@ModelAttribute("newUserInfo") @Valid User newUserInfo, BindingResult result, Model model, HttpSession session) {
    	
    	if(result.hasErrors()) {
    		System.out.println("Form does not validate");
    		return "NewAccount";
    	} else {
    		System.out.println("Form is valid");
    	}
    	
		landingService.save(newUserInfo);
		
		System.out.println(newUserInfo.toString());
		
		//adds a playlist to the model, so in the page NewUserPlaylist.jsp is ready to be populated with the title from the form
		model.addAttribute("playlistToCreate", new Playlist());
		
		session.setAttribute("newUserInfo", newUserInfo);
		
    	return "AccountCreated"; 	
    }
}
