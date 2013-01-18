/**
 * 
 */
package com.cisco.np6.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author test
 *
 */

@Entity
@Table(name="HOUSE")
public class House {
	
	private int houseNumber;
	private String houseName;
	
	private double houseValue;
	
	private Date constructedDate;
	
	
	private HouseAddress houseAddress;
	
	
	@OneToOne(mappedBy="house")
	@JoinColumn(name="HOUSE_ID")
	public HouseAddress getHouseAddress() {
		return houseAddress;
	}


	public void setHouseAddress(HouseAddress houseAddress) {
		this.houseAddress = houseAddress;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="HOUSE_NUMBER")
	public int getHouseNumber() {
		return houseNumber;
	}
	
	
	public void setHouseNumber(int houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	@Column(name="HOUSE_NAME")
	public String getHouseName() {
		return houseName;
	}
	public void setHouseName(String houseName) {
		this.houseName = houseName;
	}
	
	@Column(name="HOUSE_VALUE")
	public double getHouseValue() {
		return houseValue;
	}
	public void setHouseValue(double houseValue) {
		this.houseValue = houseValue;
	}
	
	@Column(name="HOUSE_DATE")
	public Date getConstructedDate() {
		return constructedDate;
	}
	public void setConstructedDate(Date constructedDate) {
		this.constructedDate = constructedDate;
	}

	

}
