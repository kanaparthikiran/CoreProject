

/**
 * This class hold the data related to item.
 * @author Jayaraj Jaganathan
 */
public class Item {

	/**
	 * Percentage of tax for an product.
	 */
	private int taxPercentage = 0;

	/**
	 * Sales tax for an product.
	 */
	private double salesTax = 0;

	/**
	 * Name of the product.
	 */
	private String name = null;

	/**
	 * Cost of the product.
	 */
	private double cost = 0.0d;

	/**
	 * Product type.
	 */
	private String type = null;

	/**
	 * Imported product.
	 */
	private boolean imported = false;

	/**
	 * Price of the product.
	 */
	private double price = 0.0d;

	/**
	 * Mandatory information of the product.
	 * @param name name of the product.
	 * @param type type of the product.
	 * @param cost cost of the product.
	 * @param imported is this product imported.
	 */
	public Item(String name, String type, double cost, boolean imported) {
		this.name = name;
		this.type = type;
		this.cost = cost;
		this.imported = imported;
	}

	/**
	 * Get the price of the product.
	 * @return price of the product.
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Set the price of the product.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Get the name of the product.
	 * @return name of the product.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the name of the product.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the cost of th product.
	 * @return cost of th product.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * set the cost of th product.
	 * @param cost cost of th product.
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Get the product type.
	 * @return product type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the product type.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Get the Imported product.
	 * @return true if it is an imported product.
	 */
	public boolean isImported() {
		return imported;
	}

	/**
	 * Set the Imported product.
	 */
	public void setImported(boolean imported) {
		this.imported = imported;
	}

	/**
	 * Get the tax Percentage.
	 * @return tax Percentage.
	 */
	public int getTaxPercentage() {
		return taxPercentage;
	}

	/**
	 * Set the tax Percentage.
	 */
	public void setTaxPercentage(int taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	/**
	 * Get the sales tax for an product.
	 * @return  sales tax for an product.
	 */
	public double getSalesTax() {
		return salesTax;
	}

	/**
	 * set the sales tax for an product.
	 * @param salesTax sales tax for an product.
	 */
	public void setSalesTax(double salesTax) {
		this.salesTax = salesTax;
	}

	/**
	 * Show the item information.
	 */
	public String toString() {
		return this.name + "\t" + this.cost + "\t" + this.imported + "\t" + this.type;
	}
}