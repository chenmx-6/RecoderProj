package com.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PlayListCollection {
	Map<String, PlayList> playListMap = new HashMap<String, PlayList>();

	public PlayListCollection() {
		super();
	}

	public PlayListCollection(Map<String, PlayList> playListMap) {
		super();
		this.playListMap = playListMap;
	}

	public Map<String, PlayList> getPlayListMap() {
		return playListMap;
	}

	public void setPlayListMap(Map<String, PlayList> playListMap) {
		this.playListMap = playListMap;
	}

	public void addPlayList(PlayList playList) {
		playListMap.put(playList.getPlayListName(), playList);
	}

	public void deletePlayList(PlayList playList) {

	}

	public PlayList searchPlayListByname(String playListName) {

		int flag = 0;
		for (String key : playListMap.keySet()) {
			if (playListName.equals(key)) {
				PlayList value = playListMap.get(key);
				flag = 1;
				return value;
			}
		}
		if (flag == 0) {
			return null;
		}
		return null;
	}

	public void displayPlayListName() {

	}

	public void exportToFile() {
		FileOutputStream fos;
		File file1 = new File("PlayList.txt");
		Iterator<String> it = this.playListMap.keySet().iterator();

		try {
			fos = new FileOutputStream("PlayList.txt");
			while (it.hasNext()) {	
				PlayList value = playListMap.get(it.next());
				byte b[] = new byte[50];
				b = (value.getPlayListName() + "\n").getBytes();
				fos.write(b);
				for (Song song : value.getMusicList()) {
					b = (song.toString() + "\n").getBytes();
					fos.write(b);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
