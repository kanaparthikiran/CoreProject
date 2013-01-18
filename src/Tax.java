/*

import java.math.BigDecimal;

public class Tax {

	*//**
	 * Rounding factor.
	 *//*
	private static final BigDecimal ROUND_FACTOR = new BigDecimal("0.05");

	private static final BigDecimal salesTaxPercentage = new BigDecimal("10");

	private static final BigDecimal importTaxPercentage = new BigDecimal("5");

	private static BigDecimal taxPercentage = null;

	public void calculateTax(Item item) {
		calculateTaxPercentage(item);
		calculateSalesTax(item);
	}	
	

	*//**
	 * Calculate tax percentage for items<BR>
	 * Sales tax is applicable at a rate of 10% on all goods, except books,<BR>
	 * food, and medical products that are exempt. Import duty is an additional<BR>
	 * sales tax applicable on all imported goods at a rate of 5%, with no<BR>
	 * exemptions.
	 * 
	 * @param item
	 *            item for sales.
	 *//*
	private void calculateTaxPercentage(Item item) {

		if (item.isTaxable()) {
			taxPercentage = salesTaxPercentage;
		} else {
			taxPercentage = new BigDecimal("0.00");
		}

		if (item.isImported()) {
			taxPercentage = taxPercentage.add(importTaxPercentage);
		}
		
		if(item.isImportDuty() ){
			taxPercentage = taxPercentage.add(new BigDecimal("3"));
		}
	}	
	

	*//**
	 * Calculate Sales Tax for an item.
	 * 
	 * @param item
	 *            item for sales.
	 *//*
	private void calculateSalesTax(Item item) {
		BigDecimal salesTax = item.getCost().multiply(taxPercentage).divide(new BigDecimal("100"));
		salesTax = roundOff(salesTax);
		item.setSalesTax(salesTax);
	}

	*//**
	 * Returns the value rounded up to the nearest 0.05.
	 * 
	 * @param value
	 *            value to be rounded
	 * @return double rounded up value
	 *//*
	private BigDecimal roundOff(BigDecimal value) {		
		value = value.divide(ROUND_FACTOR);
		value = new BigDecimal(Math.ceil(value.doubleValue()));
		value= value.multiply(ROUND_FACTOR);
		return value;
	}
	
	public static void main(String[] args) {
		//double d = ( (47.50d * 8d) / 100d );
		double d = ( (51.35d * 100d) / 47.5d );
		System.err.println(d);
		//BigDecimal bd = new BigDecimal("51.35").multiply(new BigDecimal("100.00")).divide(new BigDecimal("47.5"));
		//System.err.println(bd);
	}
	
*/