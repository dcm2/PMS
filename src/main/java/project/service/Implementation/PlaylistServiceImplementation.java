package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.Playlist;
import project.persistence.repositories.PlaylistRepository;
import project.service.PlaylistService;

@Service
public class PlaylistServiceImplementation implements PlaylistService{
	
	// Instance Variable
	PlaylistRepository playlistRepo;
	
	@Autowired
	public PlaylistServiceImplementation(PlaylistRepository playlistRepo) {
		this.playlistRepo = playlistRepo;
	}
	
	/* IMPLEMENTATION OF METHODS IN THE PlaylistService INTERFACE*/
	
	@Override
	public Playlist save(Playlist playlist) {
		return playlistRepo.save(playlist);
	}
	
	@Override
	public Playlist findByTitle(String title) {
		return playlistRepo.findByTitle(title);
	}
	
	
}
