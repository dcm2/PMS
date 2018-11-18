package project.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
	public List<User> findAll() {
		return userRepo.findAll();
	}
	
	@Override
	public boolean isUserInDB(String name) {
		
		User prospect = new User();
		prospect = userRepo.findUserByName(name);
		
		if (prospect == null) {
			return false;
		}
		
		return true;		
	}
	
	@Override
	public boolean verification(User user) {
		User prospect = new User();
		prospect = userRepo.findUserById(user.getId());
		
		if (prospect == null) {
			return true;
		}
		return false;
	}
}
