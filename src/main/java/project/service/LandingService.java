package project.service;

import java.util.List;

import project.persistence.entities.User;

public interface LandingService {

    /**
     * Save a {@link User}
     * @param user {@link User} to be saved
     * @return {@link User} that was saved
     */
	User save(User user);

    /**
     * Delete {@link User}
     * @param user {@link PostitNote} to be deleted
     */
	void delete(User user);
	
	/**
     * Get all {@link User}s
     * @return A list of {@link User}s
     */
	List<User> findAll();
	
}
