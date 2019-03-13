package com.baizhi.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Banner implements Serializable{
	private String id;
	private String title;
	private String imgPath;
	private String desc;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonFormat(timezone="GMT+8",pattern="yyyy-MM-dd")
	//@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	private Integer status;
	private String ext1;
	private String ext2;

	
}
