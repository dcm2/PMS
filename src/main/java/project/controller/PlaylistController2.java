package project.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttribute;

import project.beans.SearchInfo;
import project.persistence.entities.Playlist;
import project.persistence.entities.User;
import project.service.LandingService;
import project.service.PlaylistService;

@Controller
public class PlaylistController2 {
	
	//Instance Variables
	private PlaylistService playlistService;
	private LandingService landingService;
	
	@Autowired
	public PlaylistController2(PlaylistService playlistService, LandingService landingService) {
		this.playlistService = playlistService;
		this.landingService = landingService;
	}
	
	@RequestMapping(value="/userPlaylists", method = RequestMethod.GET)
	public String newUserPlaylistsView(Model model){
	
		
		model.addAttribute("playlistToCreate", new Playlist());
		
		return "UserPlaylists";		
	}

	
	@RequestMapping(value="/userPlaylists", method=RequestMethod.POST)
	public String newUserPlaylistsPost(@ModelAttribute("playlistToCreate") Playlist playlistToCreate, @SessionAttribute("newUserInfo") User currentUser, Model model) {
			
		playlistToCreate.setCreator(currentUser);				
		
		playlistService.save(playlistToCreate);
			
		currentUser.addPlaylist(playlistToCreate);
		
		return "UserPlaylists";
	}
	
}
