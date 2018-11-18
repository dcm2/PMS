/*package project.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Song {

	private Long id;

	private int votes;
	private int upVotes;
	private int downVotes;
	private Playlist belongsTo;
	private SongInfo songInfo;
	
	// Constructors
	public Song() {
		
	}

	// Getters and setters
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "songID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
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

	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "playlistID")
	public Playlist getBelongsTo() {
		return belongsTo;
	}

	public void setBelongsTo(Playlist belongsTo) {
		this.belongsTo = belongsTo;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "songInfoID")
	public SongInfo getSongInfo() {
		return songInfo;
	}

	public void setSongInfo(SongInfo songInfo) {
		this.songInfo = songInfo;
	}
	
}*/
