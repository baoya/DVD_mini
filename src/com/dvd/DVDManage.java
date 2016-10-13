package com.dvd;

import java.util.Date;

public class DVDManage {

	// 属性
	DVD[] dvds = new DVD[1000]; // 假设最多一千张碟片

	// 这个管理类负责对这个数组进行增删改查

	public DVDManage() {
		dvds[0] = new DVD("CD0001", "泰坦尼克", "爱情片");
		dvds[1] = new DVD("CD0002", "叶问", "动作片");
		dvds[2] = new DVD("CD0003", "大话西游", "喜剧片");
		dvds[3] = new DVD("CD0004", "满城尽带黄金甲", "烂片");
	}

	public boolean addDVD(DVD dvd) {
		// 首先检查DVD编号是否重复
		if (searchId(dvd.id)) {
			System.out.println("DVD编号重复!");
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

	// 方法
	public void querryAllDvd() {
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				break;// 对象为空结束查询
			}
			System.out.println(dvds[i].showInfo());
		}
	}

	public boolean lendDVD(String id) {
		for (int i = 0; i < dvds.length; i++) {
			if (dvds[i] == null) {
				System.out.println("该碟片不存在！");
				break;// 遍历到头了都没有找到你要的DVD碟片编号，没有这张碟片
			}
			if (dvds[i].id.equals(id)) {// /找到了这张DVD碟片
				if (dvds[i].status) {
					System.out.println("该碟片已经被借出！");
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
				System.out.println("该碟片不存在！");
				break;// 遍历到头了都没有找到你要的DVD碟片编号，没有这张碟片
			}
			if (dvds[i].id.equals(id)) {// /找到了这张DVD碟片
				if (!dvds[i].status) {
					System.out.println("该碟片未被借出！");
					return false;
				}

				dvds[i].status = false;
				dvds[i].returnTime = new Date();
				return true;
			}
		}
		return false;
	}

	// 显示主菜单的方法
	public void showMenu() {
		System.out.println("**********迷你DVD管理系统************");
		System.out.println("1.查询所有DVD资料");
		System.out.println("2.新增DVD资料");
		System.out.println("3.删除DVD资料");
		System.out.println("4.借出DVD");
		System.out.println("5.归还DVD");
		System.out.println("6.退出系统");
		System.out.println("请选择1-6：");
	}
}
