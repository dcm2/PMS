package project.service;

import project.persistence.entities.Playlist;


public interface PlaylistService {

	Playlist save(Playlist playlist);
	
	Playlist findByTitle(String title);

	
}
