package project.service;

import project.persistence.entities.User;
import project.beans.UserInfo;

public interface LandingService {

	User save(User user);

	void delete(User user);
	
	boolean isUserInDB(String name);
	
	boolean verification(UserInfo userInfo);

	User findByName(String userName);
}
