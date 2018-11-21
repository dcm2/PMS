package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import project.persistence.entities.Playlist;
import project.persistence.entities.User;

public interface PlaylistRepository extends JpaRepository<User, Long>{

	Playlist save(Playlist playlist);
	
}
