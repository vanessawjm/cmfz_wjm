package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Meun implements Serializable{
	private String id;
	private String title;
	private String href;
	private String iconCls;
	//private String parentId;
	private String ext1;
	private String ext2;
	private String ext3;
	private List<Meun> secondMeun;

	
	
}
