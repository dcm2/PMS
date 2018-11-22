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
	public String newUserPlaylistsView(Model model, HttpSession session){
		
		model.addAttribute("playlistToCreate", new Playlist());
		
		return "NewUserPlaylists";		
	}

	
	@RequestMapping(value="/newUserPlaylists", method=RequestMethod.POST)
	public String newUserPlaylistsPost(@ModelAttribute("playlistToCreate") Playlist playlistToCreate, @SessionAttribute("newUserInfo") User currentUser, Model model) {
		
		System.out.println("playlist to save:" + playlistToCreate.getTitle());
		
		playlistService.save(playlistToCreate);
	
		System.out.println("added to playlist from user: " + currentUser.getUserName());
		
		//Set<Playlist> pl = currentUser.getPlaylists();
		//pl.add(playlistToCreate);
		
		System.out.println("done!");
		System.out.println(currentUser);
		
		
		return "NewUserPlaylists";
	}
	
	
	
}
