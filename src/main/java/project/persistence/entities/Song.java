/*package project.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Song {

	//private Long id;

	private int votes;
	private int upVotes;
	private int downVotes;
	private SongInfo songInfo;
	
	// Constructor
	public Song(SongInfo songInfo) {
		this.setSongInfo(songInfo);
	}
	
	// Getters and setters
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	
	public int getUpVotes() {
		return upVotes;
	}

	public void setUpVotes(int upVotes) {
		this.upVotes = upVotes;
	}
	
	public int getDownVotes() {
		return downVotes;
	}

	public void setDownVotes(int downVotes) {
		this.downVotes = downVotes;
	}

	public SongInfo getSongInfo() {
		return songInfo;
	}

	public void setSongInfo(SongInfo songInfo) {
		this.songInfo = songInfo;
	}
}*/
