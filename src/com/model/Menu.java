package com.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	private PlayList mainList=new PlayList("主歌单");
	private PlayListCollection player=new PlayListCollection();
	public void Menu() {
	}
	public void menu() {
		System.out.println("*****************************************************");
		System.out.println("                主菜单                          ");
		System.out.println("            1--播放列表管理                  ");
		System.out.println("            2--播放器管理                     ");
		System.out.println("            0--退出                                ");
		System.out.println("*****************************************************");
		System.out.println("请输入对应数字进行操作：                         ");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		switch(result) {
		case 1:this.playListMenu();break;
		case 2:this.playerMenu();break;
		case 0:return;
		default:System.out.println("输入错误！");
		}
		sc.close();
	}
	public void playListMenu() {
		System.out.println("*****************************************************");
		System.out.println("                播放列表管理                          ");
		System.out.println("            1--将歌曲添加到主播放列表                  ");
		System.out.println("            2--将歌曲添加到普通播放列表                     ");
		System.out.println("            3--通过歌曲id查询播放列表中的歌曲                                ");
		System.out.println("            4--通过歌曲名称查询播放列表中的歌曲                                ");
		System.out.println("            5--修改播放列表中的歌曲                                ");
		System.out.println("            6--删除播放列表中的歌曲                                ");
		System.out.println("            7--显示播放列表中的歌曲                                ");
		System.out.println("            8--导出歌单                                ");
		System.out.println("            0--返回上一级菜单                                ");
		System.out.println("****************************************************");
		System.out.println("请输入对应数字进行操作：                         ");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		switch(result) {
		case 0:menu();break;
		case 1:addSongToMain();break;
		case 2:addSongToOther();break;
		case 3:searchSongByIdInOtherList();break;
		case 4:searchSongByNameInOtherList();break;
		case 5:modifySong();break;
		case 6:deleteSong();break;
		case 7:displaySong();break;
		case 8:exportToFile();break;
		default:System.out.println("输入错误！");
		}
		
	}
	public void playerMenu() {
		System.out.println("*****************************************************");
		System.out.println("                播放器管理                          ");
		System.out.println("             1--向播放器添加播放列表                          ");
		System.out.println("             2--从播放器删除播放列表                          ");
		System.out.println("             3--通过名字查询播放列表                          ");
		System.out.println("             4--显示所有播放列表名称                          ");
		System.out.println("             0--返回上一级菜单                          ");
		System.out.println("*****************************************************");
		System.out.println("请输入对应数字进行操作：                         ");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		switch(result) {
		case 0:this.menu();break;
		case 1:this.addListToPlayer();break;
		case 2:this.deletePlayListFromPlayer();break;
		case 3:this.searchListByName();break;
		case 4:this.displayAllList();break;
		default:System.out.println("输入错误！");
		}
	}
	
	//菜单1.1
	public void addSongToMain() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("将歌曲添加到主播放列表");
		System.out.println("请输入要导入的歌曲数：");
		int num=sc.nextInt();
		for(int n=num;n>0;n--) {
			System.out.println("请输入歌曲编号：");
			String songId=sc.next();
			System.out.println("请输入歌曲名称：");
			String songName=sc.next();
			System.out.println("请输入歌手：");
			String songSinger=sc.next();
			Song s1=new Song(songId,songName,songSinger);
			this.mainList.addToPlayList(s1);
		}
		this.mainList.displayAllSong();
		this.playListMenu();
	}
	public void addSongToMain(String sid) {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入歌曲其他信息：");
			String songId=sid;
			System.out.println("请输入歌曲名称：");
			String songName=sc.next();
			System.out.println("请输入歌手：");
			String songSinger=sc.next();
			Song s1=new Song(songId,songName,songSinger);
			this.mainList.addToPlayList(s1);
			this.mainList.displayAllSong();
	}
	
	
	
	//菜单1.2
	public void addSongToOther() {
		Scanner sc=new Scanner(System.in);
		int flag1=1;
		int flag2=1;
		System.out.println("*****************************************************");
		System.out.println("将歌曲添加到普通播放列表  ");
		System.out.println("请输入要添加的播放列表的名称：");
		String listName=sc.next();
		PlayList pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("没有该播放列表，是否新建该歌单：（1：是       0：否）:");
			int isSetNewList=sc.nextInt();
			if(isSetNewList==1) {
				this.addListToPlayer(listName);
			}
		}
		pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			flag1=0;
		}
		System.out.println("请输入要添加的歌曲的编号：");
		String songId=sc.next();
		Song s=mainList.searchSongById(songId);
		if(s==null) {
			System.out.println("没有该歌曲，是否新建该歌曲：（1：是       0：否）:");
			int isSetNewSong=sc.nextInt();
			if(isSetNewSong==1) {
				this.addSongToMain(songId);
			}
		}
		s=mainList.searchSongById(songId);
		if(s==null) {
			flag2=0;
		}
		if(flag1*flag2==1) {
			pl.addToPlayList(s);
		}
		this.playListMenu();
	}
	
	
	
	//菜单1.3
	public void searchSongByIdInOtherList() {
		int flag1=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要查找的播放列表名称：");
		String listName=sc.next();
		PlayList pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("没有该播放列表，是否新建该歌单：（1：是       0：否）:");
			int isSetNewList=sc.nextInt();
			if(isSetNewList==1) {
				this.addListToPlayer(listName);
			}
		}
		pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			flag1=0;
		}
		if(flag1==1) {
			System.out.println("请输入要查找的歌曲的编号：");
			String songId=sc.next();
			Song s=pl.searchSongById(songId);
			if(s==null) {
				System.out.println("该歌曲不存在！");
			}else {
				System.out.println("该歌曲存在！");
				System.out.println(s);
				pl.displayAllSong();
			}
		}
		this.playListMenu();
	}
	
	//菜单1.4
	public void searchSongByNameInOtherList() {
		int flag1=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("请输入要查找的播放列表名称：");
		String listName=sc.next();
		PlayList pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("没有该播放列表，是否新建该歌单：（1：是       0：否）:");
			int isSetNewList=sc.nextInt();
			if(isSetNewList==1) {
				this.addListToPlayer(listName);
			}
		}
		pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			flag1=0;
		}
		if(flag1==1) {
			System.out.println("请输入要查找的歌曲的名称：");
			String songName=sc.next();
			Song s=pl.searchSongByName(songName);
			if(s==null) {
				System.out.println("该歌曲不存在！");
			}else {
				System.out.println("该歌曲存在！");
				System.out.println(s);
				pl.displayAllSong();
			}
		}
		this.playListMenu();
	}
	
	
	
	//菜单1.5
	public void modifySong() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入要修改的歌曲的名称：");
		String songName=sc.next();
		Song s=this.mainList.searchSongByName(songName);
		if(s==null) {
			System.out.println("该歌曲不存在！");
		}else {
			System.out.println("请输入歌曲编号：");
			String sId=sc.next();
			s.setSongId(sId);
			System.out.println("请输入歌曲名称：");
			String sName=sc.next();
			s.setSongName(sName);
			System.out.println("请输入歌手：");
			String sSinger=sc.next();
			s.setSongSinger(sSinger);
			System.out.println("修改成功！");
			System.out.println(s);
		}
		this.playListMenu();
	}
	
	
	
	//菜单1.6
	public void deleteSong() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入要删除的歌曲的名称：");
		String songName=sc.next();
		Song s=this.mainList.searchSongByName(songName);
		if(s==null) {
			System.out.println("该歌曲不存在！");
		}else {
			this.mainList.getMusicList().remove(s);
			System.out.println("该歌曲已删除！");
		}
		this.mainList.displayAllSong();
		this.playListMenu();
	}
	//菜单1.7
	public void displaySong() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入要展示的播放列表名称");
		String listName=sc.next();
	    PlayList pl=this.player.searchPlayListByName(listName);
	    if(pl==null) {
	    	System.out.println("NotFound!");
	    }else {
	    	pl.displayAllSong();
	    }
		this.playListMenu();
	}
	
	//菜单1.8
	public void exportToFile() {
		System.out.println("*****************************************************");
		this.player.exportToFile();
		System.out.println("已导出文件！");
		this.playListMenu();
	}
	
	

	//菜单2.1
	public void addListToPlayer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入要添加的播放列表名称：");
		String listName=sc.next();
		PlayList pl=new PlayList(listName);
		this.player.addPlayList(pl);
		this.playerMenu();
	}
	public void addListToPlayer(String name) {
		PlayList pl=new PlayList(name);
		this.player.addPlayList(pl);
	}
	
	
	//菜单2.2
	public void deletePlayListFromPlayer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入要删除的播放列表名称：");
		String listName=sc.next();
		PlayList pl=player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("没有该列表！");
		}else {
			player.getPlayListMap().entrySet().removeIf(entry->entry.getKey()==listName);
		    System.out.println("已删除！");
		}
		this.playerMenu();
	}
	
	//菜单2.3
	public void searchListByName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("请输入要查找的播放列表名称：");
		String listName=sc.next();
		PlayList pl=player.searchPlayListByName(listName);
		pl.displayAllSong();
		this.playerMenu();
	}
	
	
	//菜单2.4
	public void displayAllList() {
		System.out.println("*****************************************************");
		System.out.println("显示所有播放列表名称：");
		Iterator<String> it=this.player.getPlayListMap().keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		this.playerMenu();
	} 
	public PlayList getMainList() {
		return mainList;
	}
	public void setMainList(PlayList mainList) {
		this.mainList = mainList;
	}
	public PlayListCollection getPlayer() {
		return player;
	}
	public void setPlayer(PlayListCollection player) {
		this.player = player;
	}
	
	

}
