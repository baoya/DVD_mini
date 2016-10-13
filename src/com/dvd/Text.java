package com.dvd;

import java.util.Scanner;

public class Text {
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int choice;
		
		DVDManage dm = new DVDManage();
		dm.showMenu();
		choice = in.nextInt();
		while(choice!=6){
			switch(choice){
			case 1:
				System.out.println("您选择了查询DVD资料......");
				dm.querryAllDvd();
				break;
			case 2:
				System.out.println("您选择了新增DVD资料......");
				String id2;
				String name;
				String type;
				System.out.println("请输入碟片的编号：");
				id2 = in.next();
				System.out.println("请输入碟片的片名：");
				name = in.next();
				System.out.println("请输入碟片的类型：");
				type = in.next();
				DVD dvd = new DVD(id2,name,type);
				if(dm.addDVD(dvd)){
					
					System.out.println("添加DVD成功！");
				}
				else{
					System.out.println("添加DVD失败！");
				}
				break;
			case 3:
				System.out.println("您选择了删除DVD资料......");
				String id3;
				System.out.println("请输入你要删除的DVD编号：");
				id3 = in.next();
				if(dm.deleteDVD(id3)){
					System.out.println("删除成功");
				}
				else{
					System.out.println("删除失败!");
				}
				break;
			case 4:
				System.out.println("您选择了借出DVD......");
				System.out.println("请输入您要借出的DVD的编号：");
				String id4 = in.next();
				if(dm.lendDVD(id4))
				{
					System.out.println("借出成功！");
				}
				else{
				System.out.println("借出失败！");
				}
				break;
			case 5:
				System.out.println("您选择了归还DVD......");
				System.out.println("请输入您要归还的DVD的编号：");
				String id5 = in.next();
				if(dm.returnDVD(id5))
				{
					System.out.println("归还成功！");
				}
				else{
				System.out.println("归还失败！");
				}
				break;
			}
			dm.showMenu();
			choice = in.nextInt();
			
		}
		System.out.println("谢谢您的使用！");
	}
}
