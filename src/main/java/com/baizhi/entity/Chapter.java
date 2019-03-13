package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chapter implements Serializable{
	private String id;
	private String title;
	private String url;
	private Long size;
	private String duration;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
	private Date createTime;
	private String albumId;

	
	
	
}
