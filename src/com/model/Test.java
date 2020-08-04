package com.model;

import java.util.ArrayList;
import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//Test test=new Test();
		Menu menu=new Menu();
		menu.getPlayer().addPlayList(menu.getMainList());
		menu.menu();
		System.out.println("ÍË³öÏµÍ³£¡");
	}

	

}
