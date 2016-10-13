package com.dvd;

import java.util.Date;

public class DVDManage {

	// ����
	DVD[] dvds = new DVD[1000]; // �������һǧ�ŵ�Ƭ

	// ��������ฺ���������������ɾ�Ĳ�

	public DVDManage() {
		dvds[0] = new DVD("CD0001", "̩̹���", "����Ƭ");
		dvds[1] = new DVD("CD0002", "Ҷ��", "����Ƭ");
		dvds[2] = new DVD("CD0003", "������", "ϲ��Ƭ");
		dvds[3] = new DVD("CD0004", "���Ǿ����ƽ��", "��Ƭ");
	}

	public boolean addDVD(DVD dvd) {
		// ���ȼ��DVD����Ƿ��ظ�
		if (searchId(dvd.id)) {
			System.out.println("DVD����ظ�!");
			return false;
		} else {
			for (int i = 0; i < dvds.length; i++) {
				if (dvds[i] == null) {
					dvds[i] = dvd;
					return true;
				}
			}
		}
		return false;
	}

	public boolean searchId(String id) {

		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				return false;
			}
			if (dvds[i].id.equals(id)) {
				return true;
			}
		}
		return false;
	}

	public boolean deleteDVD(String id) {
		int pos = -1;
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i].id.equals(id)) {
				pos = i;
				for (; pos < dvds.length && dvds[pos] != null; pos++) {
					dvds[pos] = dvds[pos + 1];
				}
				return true;
			}
		}
		return false;
	}

	// ����
	public void querryAllDvd() {
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				break;// ����Ϊ�ս�����ѯ
			}
			System.out.println(dvds[i].showInfo());
		}
	}

	public boolean lendDVD(String id) {
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				System.out.println("�õ�Ƭ�����ڣ�");
				break;// ������ͷ�˶�û���ҵ���Ҫ��DVD��Ƭ��ţ�û�����ŵ�Ƭ
			}
			if (dvds[i].id.equals(id)) {// /�ҵ�������DVD��Ƭ
				if (dvds[i].status) {
					System.out.println("�õ�Ƭ�Ѿ��������");
					return false;
				}

				dvds[i].status = true;
				dvds[i].lendTime = new Date();
				return true;
			}
		}
		return false;
	}

	public boolean returnDVD(String id) {
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				System.out.println("�õ�Ƭ�����ڣ�");
				break;// ������ͷ�˶�û���ҵ���Ҫ��DVD��Ƭ��ţ�û�����ŵ�Ƭ
			}
			if (dvds[i].id.equals(id)) {// /�ҵ�������DVD��Ƭ
				if (!dvds[i].status) {
					System.out.println("�õ�Ƭδ�������");
					return false;
				}

				dvds[i].status = false;
				dvds[i].returnTime = new Date();
				return true;
			}
		}
		return false;
	}

	// ��ʾ���˵��ķ���
	public void showMenu() {
		System.out.println("**********����DVD����ϵͳ************");
		System.out.println("1.��ѯ����DVD����");
		System.out.println("2.����DVD����");
		System.out.println("3.ɾ��DVD����");
		System.out.println("4.���DVD");
		System.out.println("5.�黹DVD");
		System.out.println("6.�˳�ϵͳ");
		System.out.println("��ѡ��1-6��");
	}
}
