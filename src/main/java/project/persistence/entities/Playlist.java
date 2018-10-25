package project.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import java.util.ArrayList;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Playlist {
	
	private Long id;
	
	private String title;
	private User creator;
	private ArrayList<Song> songList;
	private	int numSongs;
	private int duration;
	private ArrayList<User> members;
	
	// The empty constructor is not needed, we will always want to create Playlists with
	// a title and the user that creates it
	public Playlist(String title, User creator) {
		this.title = title;
		this.creator = creator;
	}
	
	// All the getters & setters
	@Id
	@Column(name = "playlistID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public ArrayList<Song> getSongList() {
		return songList;
	}
	public void setSongList(ArrayList<Song> songList) {
		this.songList = songList;
	}
	public int getNumSongs() {
		return numSongs;
	}
	public void setNumSongs(int numSongs) {
		this.numSongs = numSongs;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public ArrayList<User> getMembers() {
		return members;
	}
	public void setMembers(ArrayList<User> members) {
		this.members = members;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "UserID")
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	
}