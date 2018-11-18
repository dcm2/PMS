package project.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
	
	private Long id;
	
	private String userName;
	private String password;
	private String email;
	private char[] playlists;
	private Set<Playlist> createdPlaylists = new HashSet<>();
	
    // Empty constructor: because we need to be able to create an empty User to add
    // to our model so we can use it with our form
    public User() {
    }
	
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
    
    // Getters & setters
	@Id
	@Column(name = "UserID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
    public char[] getPlaylists() {
		return playlists;
	}

	public void setPlaylists(char[] playlists) {
		this.playlists = playlists;
	}
	
    // This handles the one-to-many relationship with the playlist
    
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) 
	public Set<Playlist> getCreatedPlaylists() {
		return createdPlaylists;
	}

	public void setCreatedPlaylists(Set<Playlist> createdPlaylists) {
		this.createdPlaylists = createdPlaylists;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", playlists=" + Arrays.toString(playlists) + ", createdPlaylists=" + createdPlaylists + "]";
	}
	
	
	
	
}
