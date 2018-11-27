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
public class Song {

	private Long id;
	private int votes;
	private int upVotes;
	private int downVotes;
	private String title;
	
	private Playlist belongsTo;
	private SongInfo songInfo;
	
	public Song() {
	}
	
	// Constructors
	public Song(SongInfo songInfo) {
		this.songInfo = songInfo;
		this.title = songInfo.getTitle();
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", votes=" + votes + ", upVotes=" + upVotes + ", downVotes=" + downVotes + ", title="
				+ title + ", belongsTo=" + belongsTo + ", songInfo=" + songInfo + "]";
	}

	
		
}
