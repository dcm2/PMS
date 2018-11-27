package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Long>{

	Playlist save(Playlist playlist);
	
	// To find a particular playlist by title
	@Query(value= "SELECT p FROM Playlist p WHERE p.title = ?1")
	Playlist findByTitle(String title);
	
	
}
