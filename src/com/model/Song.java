package com.model;

public class Song {
	private String SongId;
	private String SongName;
	private String SongSinger;
	
	
	public Song() {
		super();
	}
	public Song(String songId, String songName, String songSinger) {
		super();
		SongId = songId;
		SongName = songName;
		SongSinger = songSinger;
	}

	
	public String getSongId() {
		return SongId;
	}
	public void setSongId(String songId) {
		SongId = songId;
	}
	public String getSongName() {
		return SongName;
	}
	public void setSongName(String songName) {
		SongName = songName;
	}
	public String getSongSinger() {
		return SongSinger;
	}
	public void setSongSinger(String songSinger) {
		SongSinger = songSinger;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((SongId == null) ? 0 : SongId.hashCode());
		result = prime * result + ((SongName == null) ? 0 : SongName.hashCode());
		result = prime * result + ((SongSinger == null) ? 0 : SongSinger.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Song other = (Song) obj;
		if (SongId == null) {
			if (other.SongId != null)
				return false;
		} else if (!SongId.equals(other.SongId))
			return false;
		if (SongName == null) {
			if (other.SongName != null)
				return false;
		} else if (!SongName.equals(other.SongName))
			return false;
		if (SongSinger == null) {
			if (other.SongSinger != null)
				return false;
		} else if (!SongSinger.equals(other.SongSinger))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "∏Ë«˙–≈œ¢£∫ [∏Ë«˙±‡∫≈£∫" + SongId + ", ∏Ë«˙√˚≥∆£∫" + SongName + ", ∏Ë ÷£∫" + SongSinger + "]";
	}

}
