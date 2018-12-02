package project.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.beans.UserInfo;
import project.persistence.entities.Playlist;
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

    @RequestMapping(value= "/", method=RequestMethod.POST)
    public String logInPost(@ModelAttribute("userInfo") @Valid UserInfo userInfo, BindingResult result, Model model, HttpSession session) {

    	if(result.hasErrors()) {
    		System.out.println("Form does not validate");
    		return "Landing";
    	} else {
    		System.out.println("Form is valid and ready to check in the db info from UserInfo bean");
    	}	
    	
    	
    	if(!landingService.verification(userInfo)){ return "ErrorNoAccount"; }
    	
    	
    	User user = landingService.findByName(userInfo.getUserName());
    	System.out.println("user to add to session: " + user);
    	
    	//adds a playlist to the model, so in the page UserPlaylist.jsp is ready to be populated with the title from the form
    	model.addAttribute("playlistToCreate", new Playlist());
    	
    	session.setAttribute("sessionUser", user);
    	

    	return "UserPlaylists"; 	
    }
   
    
}