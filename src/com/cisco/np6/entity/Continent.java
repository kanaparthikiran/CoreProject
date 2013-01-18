/**
 * 
 */
package com.cisco.np6.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import javax.persistence.CascadeType;


/**
 * @author test
 *
 */
@Entity
@Table(name="CONTINENT")
public class Continent {
	
	private int continentId;
	
	private String continentName;
	
	private String contintDescription;
	
	private Set<Country> countries = new HashSet<Country>();

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CONTINENT_ID")
	public int getContinentId() {
		return continentId;
	}

	public void setContinentId(int continentId) {
		this.continentId = continentId;
	}

	@Column(name="CONTINENT_NAME")
	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	@Column(name="CONTINENT_DESC")
	public String getContintDescription() {
		return contintDescription;
	}

	public void setContintDescription(String contintDescription) {
		this.contintDescription = contintDescription;
	}


	
/*	@OneToMany (mappedBy="CONTINENT", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@org.hibernate.annotations.Cascade( {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinColumn(name= "CONTINENT_ID")*/
	
	@OneToMany (mappedBy="continent", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@org.hibernate.annotations.Cascade( {org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//	@JoinColumn(name = "CONT_ID")
	public Set<Country> getCountries() {
		return countries;
	}

	public void setCountries(Set<Country> countries) {
		this.countries = countries;
	}
	
	/**
	 * 
	 * @param country
	 */
	public void addCountry(Country country) {
		country.setContinent(this);
		countries.add(country);
	}

}
