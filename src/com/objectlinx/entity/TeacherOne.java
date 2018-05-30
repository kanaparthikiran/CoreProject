/**
 * 
 */
package com.objectlinx.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author test
 *
 */

@Entity
@Table(name="TEACHERONE")
public class TeacherOne {
	
	private int teacherId;
	private String teacherName;
	private String teacherSalary;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="TEACHER_ID")
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	
	@Column(name="TEACHER_NAME")
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	@Column(name="TEACHER_SALARY")
	public String getTeacherSalary() {
		return teacherSalary;
	}
	public void setTeacherSalary(String teacherSalary) {
		this.teacherSalary = teacherSalary;
	}

}
