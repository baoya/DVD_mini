package com.dvd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DVD {
	
	//属性
	String id;//编号
	String name;//片名
	String type;//类型
	boolean status;//是否被借出
	Date lendTime;//借出时间
	Date returnTime;//归还时间
	public DVD(String id,String name,String type) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = false;
		this.lendTime = null;
		this.returnTime = null;
	}
	
	
	public String showInfo()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH:mm:ss a");
		String isLend;
		isLend = this.status?"已借出":"未借出";
		String bt;//借出时间
		bt = this.lendTime == null?"":sdf.format(this.lendTime);
		String rt;//归还时间
		rt = this.returnTime == null?"":sdf.format(this.returnTime);
		return "编号: "+this.id+",片名:<<"+this.name+">>,类型: "+this.type+",状态: "+
	isLend+",借出时间: "+bt+",归还时间: "+rt;
		
	}
	
	
	//方法

}
