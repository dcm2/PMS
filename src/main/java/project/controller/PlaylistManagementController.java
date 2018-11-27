package project.controller;

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
import project.persistence.entities.Song;
import project.persistence.entities.SongInfo;
import project.service.PlaylistService;
import project.service.SongInfoService;
import project.service.SongService;

@Controller
public class PlaylistManagementController {

	//Instance Variables
	private PlaylistService playlistService;
	private SongService songService;
	private SongInfoService songInfoService;
	
	
	@Autowired
	public PlaylistManagementController(PlaylistService playlistService, SongService songService, SongInfoService songInfoService) {
		this.playlistService = playlistService;
		this.songService = songService;
		this.songInfoService = songInfoService;
	}
	
	
	@RequestMapping(value="/playlist/{title}", method = RequestMethod.GET)
	public String playlistManagementView(@PathVariable String title, HttpSession session, Model model) {
		
		session.setAttribute("playlist", playlistService.findByTitle(title));
		
		model.addAttribute("songInfoToAdd", new SearchInfo());
			
		return "Playlist";
	}
	
	@RequestMapping(value="/playlist/{title}", method = RequestMethod.POST)
	public String playlistManagementPost(@ModelAttribute("songInfoToAdd") SearchInfo songInfoToAdd, @SessionAttribute("playlist") Playlist currentPlaylist, Model model) {
		
		//System.out.println(resultSongToSearch.getSongToSearch());
		
		//
		String searchTitle = songInfoToAdd.getSongToSearch();
		
		SongInfo resultSongInfo = songInfoService.findByTitle(searchTitle);
		
		if(resultSongInfo != null) {
			Song songToAdd = new Song(resultSongInfo);

			System.out.println(songToAdd.toString());
			
			songToAdd.setBelongsTo(currentPlaylist);
			//System.out.println("2: " + songToAdd.toString());
			
			
			//saves the Song into the db
			songService.save(songToAdd);
			//adds this song to the playlist
			currentPlaylist.addSong(songToAdd);	
			
			System.out.println("toString Song to add: " + songToAdd.toString());
			System.out.println("title of the song to add: " + songToAdd.toString());
			
		}
		else {
			return "NoSong";
		}
		
		
		return "Playlist";
	}
	
	
}
