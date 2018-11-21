package project.persistence.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;


@Entity
public class User {
	@Id 
	@Column(name = "UserID") 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="Username cannot be empty")
	@Size(min=5, max= 20, message="Username must be between 8 and 20 characters long")
	@Pattern(regexp="^\\w{5,}$", message = "Username can only consist of alphanumeric characters")
	private String userName;
	
	@NotNull(message="Password cannot be empty")
	@Pattern(regexp="\\S+", message="Your password cannot contain blank spaces")
	@Size(min=8, max=15, message="Password must be between 8 and 20 characters long")
	private String password;
	
	@NotNull
	@Email(message = "Please enter a valid email")
	private String email;
	
	
	@OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) 
	private Set<Playlist> playlists = new HashSet<>();
	
	
    // Empty constructor: because we need to be able to create an empty User to add
    // to our model so we can use it with our form
    public User() {
    }
	
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    // Getters & setters

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Set<Playlist> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(Set<Playlist> playlists) {
		this.playlists = playlists;
	}

	//for debugging purposes
	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", playlists=" + playlists + "]";
	}

}
