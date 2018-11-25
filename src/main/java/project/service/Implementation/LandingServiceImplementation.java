package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import project.beans.UserInfo;
import project.persistence.entities.User;
import project.persistence.repositories.UserRepository;
import project.service.*;

@Service
public class LandingServiceImplementation implements LandingService {

	// Instance Variable
	UserRepository userRepo;
	
	// Dependency Injection
	@Autowired
	public LandingServiceImplementation(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
/* IMPLEMENTATION OF METHODS IN THE LandingService INTERFACE*/
	
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}

	@Override
	public void delete(User user) {
		userRepo.delete(user);	
	}
	
	@Override
	public boolean isUserInDB(String name) {
		
		User prospect = new User();
		prospect = userRepo.findByName(name);
		
		if (prospect == null) {
			return false;
		}
		
		return true;		
	}
	
	@Override
	public boolean verification(UserInfo userInfo) {
		
		String prospectiveUserName = userInfo.getUserName();
		String prospectivePw = userInfo.getPassword();
		
		if(isUserInDB(prospectiveUserName)){ 
			String pwInDB = userRepo.findUserPw(prospectiveUserName);
			return prospectivePw.equals(pwInDB);
		}
		
		return false;
	}
	
	@Override
	public User findByName(String userName) {
		return userRepo.findByName(userName);
	}
	
	
}
