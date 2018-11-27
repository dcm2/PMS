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
		

		System.out.println("Playlist created with the title (get from the form): " + playlistToCreate);
		
		playlistToCreate.setCreator(currentUser);
				
		System.out.println("Playlist to store in the db (with Creator that is the current user in this session: " + playlistToCreate);
		
		playlistService.save(playlistToCreate);
		
		System.out.println(playlistToCreate + " has been stored in the db");

		System.out.println("---------------------------------");
		
		System.out.print("The user in this session is: " + currentUser);
		System.out.println(". Playlists that the user has right now: " + currentUser.getPlaylists());
		
		
		currentUser.addPlaylist(playlistToCreate);
		
		System.out.println(currentUser.getUserName() + " has right now the following playlists: " + currentUser.getPlaylists());
		
		System.out.println("done!");

		
		return "UserPlaylists";
	}

	
	/*@RequestMapping(value="/users/{userName}", method = RequestMethod.GET)
	public String userGetViewFromName(@PathVariable String userName, Model model) {
		model.addAttribute("user", landingService.findByName(userName));
		return "User";
	}*/
	
	
}
