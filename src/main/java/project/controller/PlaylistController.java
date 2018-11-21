package project.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import project.persistence.entities.Playlist;
import project.persistence.entities.User;
import project.service.PlaylistService;

@Controller
public class PlaylistController {
	
	//Instance Variables
	private PlaylistService playlistService;
	
	@Autowired
	public PlaylistController(PlaylistService playlistService) {
		this.playlistService = playlistService;
	}
	
	@RequestMapping(value="/newUserPlaylists", method = RequestMethod.GET)
	public String newUserPlaylistsView(Model model){

		return "NewUserPlaylists";		
	}

	
	@RequestMapping(value="/newUserPlaylists", method=RequestMethod.POST)
	public String newUserPlaylistsPost(@ModelAttribute("playlistToCreate") Playlist playlistToCreate, @ModelAttribute("newUserInfo") User currentUser, Model model) {
		
		playlistService.save(playlistToCreate);
	
		System.out.println(currentUser.getUserName());
		
		//Set<Playlist> pl = currentUser.getPlaylists();
		//pl.add(playlistToCreate);
		
		
		return "NewUserPlaylists";
	}
	
	
	
}
