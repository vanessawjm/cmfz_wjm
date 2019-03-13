package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article implements Serializable{
	private String id;
	private String title;
	private String author;
	private String type;
	private Date createTime;

	

}
