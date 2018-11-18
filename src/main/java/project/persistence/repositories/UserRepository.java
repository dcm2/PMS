package project.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import project.persistence.entities.*;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

	User save(User user);
	
	void delete(User user);
	
	List<User> findAll();
	
	// To look for a user by its name
	@Query(value= "SELECT p FROM User p WHERE p.userName = ?1")
	User findByName(String userName);
	
	
	
	
}
