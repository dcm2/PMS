package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Song;


public interface SongRepository extends JpaRepository<Song, Long>{
	
	Song save(Song song);
}
