package com.model;

import java.util.ArrayList;

public class PlayList {
	private String playListName;
	private ArrayList<Song> musicList;
	
	
	public PlayList() {
		super();
	}

	public PlayList(String playListName) {
		super();
		this.playListName = playListName;
	}
	public PlayList(String playListName, ArrayList<Song> musicList) {
		super();
		this.playListName = playListName;
		this.musicList = musicList;
	}

	
	
	
	public String getPlayListName() {
		return playListName;
	}
	public void setPlayListName(String playListName) {
		this.playListName = playListName;
	}
	public ArrayList<Song> getMusicList() {
		return musicList;
	}
	public void setMusicList(ArrayList<Song> musicList) {
		this.musicList = musicList;
	}
	
	public void addToPlayList(Song song) {
		if(this.musicList==null) {
			this.musicList=new ArrayList<Song>();
		}
		this.musicList.add(song);
	}
	public void displayAllSong() {
		System.out.println("****************"+this.playListName+"**************");
		for(Song song:musicList) {
			System.out.println(song);
		}
	}
    public Song searchSongById(String id) {
//		for(int i=0;i<musicList.size();i++) {
//			if(id.equals(musicList.get(i).getSongId())) {
//				return musicList.get(i);
//			}
//		}
		for(Song song:musicList) {
			if(id.equals(song.getSongId())) {
				return song;
			}
		}
		return null;
	}
    public Song searchSongByName(String n) {
		for(Song song:musicList) {
			if(n.equals(song.getSongName())) {
				return song;
			}
		}
		return null;
	}
    public void updateSong(String id,Song song) {
    	
	}
    public void deleteSong(String id,Song song) {
		
	}
    
	

}
