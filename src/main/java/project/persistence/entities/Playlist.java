package project.persistence.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private	int numSongs;
	private int duration;
	
	/*@OneToMany(mappedBy = "belongsTo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) 
	private Set<Song> songList = new HashSet<>();*/

	
	public Playlist(){
	}
	
	// To create Playlists with a title and the user that creates it
	/*public Playlist(User creator) {
		this.creator = creator;
	}*/
	
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

	/*public Set<Song> getSongList() {
		return songList;
	}

	public void setSongList(Set<Song> songList) {
		this.songList = songList;
	}*/

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

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "UserID")
	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", title=" + title + ", creator=" + creator + ", numSongs=" + numSongs
				+ ", duration=" + duration + "]";
	}
	
	
	
}
