/**
 * 
 */
package com.cisco.np6.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author kikanapa
 *
 */

@Entity
@Table(name="STREET")
public class Street {
	
	@Id
	@Column(name="STREET_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long streetId;
	
	@Column(name="STREET_NAME")
	private String streetName;
	
	@Column(name="STREET_NUMBER")
	private String streetNumber;
	
	


	public long getStreetId() {
		return streetId;
	}

	public void setStreetId(long streetId) {
		this.streetId = streetId;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	
	

}
