/**
 * 
 */
package com.cisco.np6.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author kikanapa
 *
 */

@Entity
@Table(name="CITY")
public class City {
	
	@Id
	@Column(name="CITY_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cityId;
	

	
	@OneToMany
	@JoinColumn(name="CITY_ID")
	private List<Street> streets = new ArrayList<Street>();
	
	public List<Street> getStreets() {
		return streets;
	}

	public void setStreets(List<Street> streets) {
		this.streets = streets;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityId == null) ? 0 : cityId.hashCode());
		result = prime * result
				+ ((cityName == null) ? 0 : cityName.hashCode());
		result = prime * result
				+ ((cityType == null) ? 0 : cityType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		City other = (City) obj;
		if (cityId == null) {
			if (other.cityId != null)
				return false;
		} else if (!cityId.equals(other.cityId))
			return false;
		if (cityName == null) {
			if (other.cityName != null)
				return false;
		} else if (!cityName.equals(other.cityName))
			return false;
		if (cityType == null) {
			if (other.cityType != null)
				return false;
		} else if (!cityType.equals(other.cityType))
			return false;
		return true;
	}


	public Long getCityId() {
		return cityId;
	}

	public void setCityId(Long cityId) {
		this.cityId = cityId;
	}


	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public String getCityType() {
		return cityType;
	}

	public void setCityType(String cityType) {
		this.cityType = cityType;
	}

	@Column(name="CITY_NAME")
	private String cityName;
	
	@Column(name="CITY_TYPE")
	private String cityType;
	
	

}
