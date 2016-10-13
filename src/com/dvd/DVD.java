package com.dvd;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DVD {
	
	//����
	String id;//���
	String name;//Ƭ��
	String type;//����
	boolean status;//�Ƿ񱻽��
	Date lendTime;//���ʱ��
	Date returnTime;//�黹ʱ��
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
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��  HH:mm:ss a");
		String isLend;
		isLend = this.status?"�ѽ��":"δ���";
		String bt;//���ʱ��
		bt = this.lendTime == null?"":sdf.format(this.lendTime);
		String rt;//�黹ʱ��
		rt = this.returnTime == null?"":sdf.format(this.returnTime);
		return "���: "+this.id+",Ƭ��:<<"+this.name+">>,����: "+this.type+",״̬: "+
	isLend+",���ʱ��: "+bt+",�黹ʱ��: "+rt;
		
	}
	
	
	//����

}
