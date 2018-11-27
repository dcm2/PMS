package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.persistence.entities.SongInfo;
import project.persistence.repositories.SongInfoRepository;
import project.service.SongInfoService;

@Service
public class SongInfoServiceImplementation implements SongInfoService{

	// Instance Variables
	private SongInfoRepository songInfoRepo;
	
	@Autowired
	public SongInfoServiceImplementation(SongInfoRepository songInfoRepo) {
		this.songInfoRepo = songInfoRepo;
	}
	
	
	@Override
	public SongInfo findByTitle(String title) {
		return songInfoRepo.findByTitle(title);
	}
}
