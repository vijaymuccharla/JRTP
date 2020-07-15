package com.vj.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="STD_TBL")
public class StudentEntity {

	@Id
	@Column(name="STD_ID")
	private Integer studentId;
	@Column(name="STD_NAME")
	private String studentName;
	@Column(name="STD_COURSE")
	private String studentCourse;
	
}
