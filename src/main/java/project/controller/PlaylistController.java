package project.controller;


import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import project.persistence.entities.Playlist;
import project.persistence.entities.User;
import project.service.LandingService;
import project.service.PlaylistService;

@Controller
public class PlaylistController {
	
	//Instance Variables
	private PlaylistService playlistService;
	private LandingService landingService;
	
	@Autowired
	public PlaylistController(PlaylistService playlistService, LandingService landingService) {
		this.playlistService = playlistService;
		this.landingService = landingService;
	}
	
	@RequestMapping(value="/newUserPlaylists", method = RequestMethod.GET)
	public String newUserPlaylistsView(Model model){
	
		
		model.addAttribute("playlistToCreate", new Playlist());
		
		return "NewUserPlaylists";		
	}

	
	@RequestMapping(value="/newUserPlaylists", method=RequestMethod.POST)
	public String newUserPlaylistsPost(@ModelAttribute("playlistToCreate") Playlist playlistToCreate, @SessionAttribute("newUserInfo") User currentUser, Model model) {

		System.out.println(playlistToCreate);
		
		playlistToCreate.setCreator(currentUser);
				
		System.out.println(playlistToCreate);
		
		System.out.println("---------------->>---------------");
		System.out.println("playlist to save:" + playlistToCreate.getTitle());
		System.out.println("Playlists that the user has right now: " + currentUser.getPlaylists());
		
		playlistService.save(playlistToCreate);
	
		
		
		System.out.println("done!");
		System.out.println(currentUser);
		System.out.println(playlistToCreate);
		
		
		return "NewUserPlaylists";
	}
	
	
	
}
