/**
 * 
 */
package com.objectlinx.entity;

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
@Table(name="HOUSEADDRESS")
public class HouseAddress {
	
	private int addressId;
	
	private String addressStreet;
	
	private String addressCity;
	
	private House house;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	@Column(name="ADDRESS_STREET")
	public String getAddressStreet() {
		return addressStreet;
	}

	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	@Column(name="ADDRESS_CITY")
	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	
	/**
	 * 
	 * @return
	 */
	@OneToOne
	@JoinColumn(name="HOUSE_ID")
	public House getHouse() {
		return house;
	}

	/**
	 * 
	 * @param house
	 */
	public void setHouse(House house) {
		this.house = house;
	}
	

}
