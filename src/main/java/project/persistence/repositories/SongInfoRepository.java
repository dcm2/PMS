package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.SongInfo;

public interface SongInfoRepository extends JpaRepository<SongInfo, Long>{

	@Query(value= "SELECT p FROM SongInfo p WHERE p.title =?1")
	SongInfo findByTitle(String titleToSearch);
	
}
