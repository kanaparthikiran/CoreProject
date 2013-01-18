package com.cisco.np6.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author test
 *
 */
@Entity
@Table(name="COUNTRY")
public class Country {

	private int countryId;
	
	private String countryName;
	
	private String countryDescription;

	private Continent continent;
	
	
	@ManyToOne
	@JoinColumn(name="CONTINENT_ID")
	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="COUNTRY_ID")
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	@Column(name="COUNTRY_NAME")
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Column(name="COUNTRY_DESC")
	public String getCountryDescription() {
		return countryDescription;
	}

	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}
	
	
}
