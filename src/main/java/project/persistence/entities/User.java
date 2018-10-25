package project.persistence.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {
	
	private Long id;
	
	private String userName;
	private String pw;
	private String email;
	private ArrayList<Playlist> playlists;
	private Set<Playlist> createdPlaylists = new HashSet<>();
	
    // Empty constructor: because we need to be able to create an empty User to add
    // to our model so we can use it with our form
    public User() {
    }
	
    public User(String userName, String pw) {
        this.userName = userName;
        this.pw = pw;
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
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public ArrayList<Playlist> getPlaylists() {
		return playlists;
	}
	public void setPlaylists(ArrayList<Playlist> playlists) {
		this.playlists = playlists;
	}
	
    // This is for easier debug 
    @Override
    public String toString() {
        return String.format(
                "User[userName=%s, pw=%s]",
                userName,pw);
    }
	
    // This handles the one-to-many relationship with the playlist
    
    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) 
	public Set<Playlist> getCreatedPlaylists() {
		return createdPlaylists;
	}

	public void setCreatedPlaylists(Set<Playlist> createdPlaylists) {
		this.createdPlaylists = createdPlaylists;
	}
	
}
