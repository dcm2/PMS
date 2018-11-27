package project.service;

import project.persistence.entities.SongInfo;

public interface SongInfoService {

	SongInfo findByTitle(String title);
	
}
