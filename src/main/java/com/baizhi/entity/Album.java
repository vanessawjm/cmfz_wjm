package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Album implements Serializable{
	private String id;
	private String title;
	private Integer score;
	private String brodcast;
	private String author;
	private String brief;
	private Date publicTime;
	private Integer count;
	private String coverImg;
	private Integer status;
	//必须给children
	private List<Chapter> children;

	
	
}

