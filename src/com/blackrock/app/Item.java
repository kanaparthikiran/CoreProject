/**
 * 
 */
package com.blackrock.app;

import java.math.BigDecimal;

/**
 * @author kiran
 *
 */
public class Item {
	
	private String itemType;
	private String itemOrigin;
	private String itemName;
	private BigDecimal tax;
	
	
	public String getItemType() {
		return itemType;
	}
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	public String getItemOrigin() {
		return itemOrigin;
	}
	public void setItemOrigin(String itemOrigin) {
		this.itemOrigin = itemOrigin;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public BigDecimal getTax() {
		return tax;
	}
	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}
	
	@Override
	public String toString() {
		return "Item [itemType=" + itemType + ", itemOrigin=" + itemOrigin
				+ ", itemName=" + itemName + ", tax=" + tax + "]";
	}
	

}
