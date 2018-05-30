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
@Table(name="STUDENTONE")
public class StudentOne {
	
	private int studentId;
	
	private String studentName;
	
	private int studentAge;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	@Column(name="STUDENT_NAME")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Column(name="STUDENT_AGE")
	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	

}
