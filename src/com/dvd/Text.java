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
				System.out.println("��ѡ���˲�ѯDVD����......");
				dm.querryAllDvd();
				break;
			case 2:
				System.out.println("��ѡ��������DVD����......");
				String id2;
				String name;
				String type;
				System.out.println("�������Ƭ�ı�ţ�");
				id2 = in.next();
				System.out.println("�������Ƭ��Ƭ����");
				name = in.next();
				System.out.println("�������Ƭ�����ͣ�");
				type = in.next();
				DVD dvd = new DVD(id2,name,type);
				if(dm.addDVD(dvd)){
					
					System.out.println("���DVD�ɹ���");
				}
				else{
					System.out.println("���DVDʧ�ܣ�");
				}
				break;
			case 3:
				System.out.println("��ѡ����ɾ��DVD����......");
				String id3;
				System.out.println("��������Ҫɾ����DVD��ţ�");
				id3 = in.next();
				if(dm.deleteDVD(id3)){
					System.out.println("ɾ���ɹ�");
				}
				else{
					System.out.println("ɾ��ʧ��!");
				}
				break;
			case 4:
				System.out.println("��ѡ���˽��DVD......");
				System.out.println("��������Ҫ�����DVD�ı�ţ�");
				String id4 = in.next();
				if(dm.lendDVD(id4))
				{
					System.out.println("����ɹ���");
				}
				else{
				System.out.println("���ʧ�ܣ�");
				}
				break;
			case 5:
				System.out.println("��ѡ���˹黹DVD......");
				System.out.println("��������Ҫ�黹��DVD�ı�ţ�");
				String id5 = in.next();
				if(dm.returnDVD(id5))
				{
					System.out.println("�黹�ɹ���");
				}
				else{
				System.out.println("�黹ʧ�ܣ�");
				}
				break;
			}
			dm.showMenu();
			choice = in.nextInt();
			
		}
		System.out.println("лл����ʹ�ã�");
	}
}
