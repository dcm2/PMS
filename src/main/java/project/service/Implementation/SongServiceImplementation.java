package project.service.Implementation;

import org.springframework.stereotype.Service;

import project.persistence.entities.Song;
import project.persistence.repositories.SongRepository;
import project.service.SongService;

@Service
public class SongServiceImplementation implements SongService{

	// Instance Variables
	private SongRepository songRepo;
	
	public SongServiceImplementation(SongRepository songRepo) {
		this.songRepo = songRepo;
	}
	
	@Override
	public Song save(Song song) {
		return songRepo.save(song);
	}
	
}
