package project.service;

import java.util.List;

import project.persistence.entities.User;
import project.beans.UserInfo;

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
	
	
	//add better comments :)
	boolean isUserInDB(String name);
	
	//add a better comments :)
	boolean verification(UserInfo userInfo);

}
