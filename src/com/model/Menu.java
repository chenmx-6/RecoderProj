package com.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Menu {
	private PlayList mainList=new PlayList("���赥");
	private PlayListCollection player=new PlayListCollection();
	public void Menu() {
	}
	public void menu() {
		System.out.println("*****************************************************");
		System.out.println("                ���˵�                          ");
		System.out.println("            1--�����б����                  ");
		System.out.println("            2--����������                     ");
		System.out.println("            0--�˳�                                ");
		System.out.println("*****************************************************");
		System.out.println("�������Ӧ���ֽ��в�����                         ");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		switch(result) {
		case 1:this.playListMenu();break;
		case 2:this.playerMenu();break;
		case 0:return;
		default:System.out.println("�������");
		}
		sc.close();
	}
	public void playListMenu() {
		System.out.println("*****************************************************");
		System.out.println("                �����б����                          ");
		System.out.println("            1--��������ӵ��������б�                  ");
		System.out.println("            2--��������ӵ���ͨ�����б�                     ");
		System.out.println("            3--ͨ������id��ѯ�����б��еĸ���                                ");
		System.out.println("            4--ͨ���������Ʋ�ѯ�����б��еĸ���                                ");
		System.out.println("            5--�޸Ĳ����б��еĸ���                                ");
		System.out.println("            6--ɾ�������б��еĸ���                                ");
		System.out.println("            7--��ʾ�����б��еĸ���                                ");
		System.out.println("            8--�����赥                                ");
		System.out.println("            0--������һ���˵�                                ");
		System.out.println("****************************************************");
		System.out.println("�������Ӧ���ֽ��в�����                         ");
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
		default:System.out.println("�������");
		}
		
	}
	public void playerMenu() {
		System.out.println("*****************************************************");
		System.out.println("                ����������                          ");
		System.out.println("             1--�򲥷�����Ӳ����б�                          ");
		System.out.println("             2--�Ӳ�����ɾ�������б�                          ");
		System.out.println("             3--ͨ�����ֲ�ѯ�����б�                          ");
		System.out.println("             4--��ʾ���в����б�����                          ");
		System.out.println("             0--������һ���˵�                          ");
		System.out.println("*****************************************************");
		System.out.println("�������Ӧ���ֽ��в�����                         ");
		Scanner sc=new Scanner(System.in);
		int result=sc.nextInt();
		switch(result) {
		case 0:this.menu();break;
		case 1:this.addListToPlayer();break;
		case 2:this.deletePlayListFromPlayer();break;
		case 3:this.searchListByName();break;
		case 4:this.displayAllList();break;
		default:System.out.println("�������");
		}
	}
	
	//�˵�1.1
	public void addSongToMain() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("��������ӵ��������б�");
		System.out.println("������Ҫ����ĸ�������");
		int num=sc.nextInt();
		for(int n=num;n>0;n--) {
			System.out.println("�����������ţ�");
			String songId=sc.next();
			System.out.println("������������ƣ�");
			String songName=sc.next();
			System.out.println("��������֣�");
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
		System.out.println("���������������Ϣ��");
			String songId=sid;
			System.out.println("������������ƣ�");
			String songName=sc.next();
			System.out.println("��������֣�");
			String songSinger=sc.next();
			Song s1=new Song(songId,songName,songSinger);
			this.mainList.addToPlayList(s1);
			this.mainList.displayAllSong();
	}
	
	
	
	//�˵�1.2
	public void addSongToOther() {
		Scanner sc=new Scanner(System.in);
		int flag1=1;
		int flag2=1;
		System.out.println("*****************************************************");
		System.out.println("��������ӵ���ͨ�����б�  ");
		System.out.println("������Ҫ��ӵĲ����б�����ƣ�");
		String listName=sc.next();
		PlayList pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("û�иò����б��Ƿ��½��ø赥����1����       0����:");
			int isSetNewList=sc.nextInt();
			if(isSetNewList==1) {
				this.addListToPlayer(listName);
			}
		}
		pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			flag1=0;
		}
		System.out.println("������Ҫ��ӵĸ����ı�ţ�");
		String songId=sc.next();
		Song s=mainList.searchSongById(songId);
		if(s==null) {
			System.out.println("û�иø������Ƿ��½��ø�������1����       0����:");
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
	
	
	
	//�˵�1.3
	public void searchSongByIdInOtherList() {
		int flag1=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫ���ҵĲ����б����ƣ�");
		String listName=sc.next();
		PlayList pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("û�иò����б��Ƿ��½��ø赥����1����       0����:");
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
			System.out.println("������Ҫ���ҵĸ����ı�ţ�");
			String songId=sc.next();
			Song s=pl.searchSongById(songId);
			if(s==null) {
				System.out.println("�ø��������ڣ�");
			}else {
				System.out.println("�ø������ڣ�");
				System.out.println(s);
				pl.displayAllSong();
			}
		}
		this.playListMenu();
	}
	
	//�˵�1.4
	public void searchSongByNameInOtherList() {
		int flag1=1;
		Scanner sc=new Scanner(System.in);
		System.out.println("������Ҫ���ҵĲ����б����ƣ�");
		String listName=sc.next();
		PlayList pl=this.player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("û�иò����б��Ƿ��½��ø赥����1����       0����:");
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
			System.out.println("������Ҫ���ҵĸ��������ƣ�");
			String songName=sc.next();
			Song s=pl.searchSongByName(songName);
			if(s==null) {
				System.out.println("�ø��������ڣ�");
			}else {
				System.out.println("�ø������ڣ�");
				System.out.println(s);
				pl.displayAllSong();
			}
		}
		this.playListMenu();
	}
	
	
	
	//�˵�1.5
	public void modifySong() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("������Ҫ�޸ĵĸ��������ƣ�");
		String songName=sc.next();
		Song s=this.mainList.searchSongByName(songName);
		if(s==null) {
			System.out.println("�ø��������ڣ�");
		}else {
			System.out.println("�����������ţ�");
			String sId=sc.next();
			s.setSongId(sId);
			System.out.println("������������ƣ�");
			String sName=sc.next();
			s.setSongName(sName);
			System.out.println("��������֣�");
			String sSinger=sc.next();
			s.setSongSinger(sSinger);
			System.out.println("�޸ĳɹ���");
			System.out.println(s);
		}
		this.playListMenu();
	}
	
	
	
	//�˵�1.6
	public void deleteSong() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("������Ҫɾ���ĸ��������ƣ�");
		String songName=sc.next();
		Song s=this.mainList.searchSongByName(songName);
		if(s==null) {
			System.out.println("�ø��������ڣ�");
		}else {
			this.mainList.getMusicList().remove(s);
			System.out.println("�ø�����ɾ����");
		}
		this.mainList.displayAllSong();
		this.playListMenu();
	}
	//�˵�1.7
	public void displaySong() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("������Ҫչʾ�Ĳ����б�����");
		String listName=sc.next();
	    PlayList pl=this.player.searchPlayListByName(listName);
	    if(pl==null) {
	    	System.out.println("NotFound!");
	    }else {
	    	pl.displayAllSong();
	    }
		this.playListMenu();
	}
	
	//�˵�1.8
	public void exportToFile() {
		System.out.println("*****************************************************");
		this.player.exportToFile();
		System.out.println("�ѵ����ļ���");
		this.playListMenu();
	}
	
	

	//�˵�2.1
	public void addListToPlayer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("������Ҫ��ӵĲ����б����ƣ�");
		String listName=sc.next();
		PlayList pl=new PlayList(listName);
		this.player.addPlayList(pl);
		this.playerMenu();
	}
	public void addListToPlayer(String name) {
		PlayList pl=new PlayList(name);
		this.player.addPlayList(pl);
	}
	
	
	//�˵�2.2
	public void deletePlayListFromPlayer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("������Ҫɾ���Ĳ����б����ƣ�");
		String listName=sc.next();
		PlayList pl=player.searchPlayListByName(listName);
		if(pl==null) {
			System.out.println("û�и��б�");
		}else {
			player.getPlayListMap().entrySet().removeIf(entry->entry.getKey()==listName);
		    System.out.println("��ɾ����");
		}
		this.playerMenu();
	}
	
	//�˵�2.3
	public void searchListByName() {
		Scanner sc=new Scanner(System.in);
		System.out.println("*****************************************************");
		System.out.println("������Ҫ���ҵĲ����б����ƣ�");
		String listName=sc.next();
		PlayList pl=player.searchPlayListByName(listName);
		pl.displayAllSong();
		this.playerMenu();
	}
	
	
	//�˵�2.4
	public void displayAllList() {
		System.out.println("*****************************************************");
		System.out.println("��ʾ���в����б����ƣ�");
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
