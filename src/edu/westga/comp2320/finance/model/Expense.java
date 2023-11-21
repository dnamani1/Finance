package edu.westga.comp2320.finance.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents expenses with unique id, date, amount,merchant, iteam,
 * category.
 * 
 * @author Deeksha Namani
 * @version 11/21/2023
 */
public class Expense implements Comparable<Expense> {
	private UUID id;
	private LocalDate date;
	private double amount;
	private String merchant;
	private String item;
	private Category category;

	/**
	 * This constructor creates a new Expense with the details.
	 *
	 * @precondition date != null && amount >= 0 && merchant != null &&
	 *               !merchant.isEmpty() && item != null && !item.isEmpty() &&
	 *               category != null
	 * 
	 * @param date     the date of the expense
	 * @param amount   the amount of the expense
	 * @param merchant the merchant where the expense occurred
	 * @param item     the item purchased
	 * @param category the category of the expense
	 */
	public Expense(LocalDate date, double amount, String merchant, String item, Category category) {
		if (date == null) {
			throw new IllegalArgumentException("Date cannot be null");
		}

		if (amount < 0) {
			throw new IllegalArgumentException("Amount should be greater than 0");
		}

		if (merchant == null || merchant.isEmpty()) {
			throw new IllegalArgumentException("Merchant cannot be null or empty");
		}

		if (item == null || item.isEmpty()) {
			throw new IllegalArgumentException("Item cannot be null or empty");
		}

		if (category == null) {
			throw new IllegalArgumentException("Category cannot be null.");
		}

		this.id = UUID.randomUUID();
		this.date = date;
		this.amount = amount;
		this.merchant = merchant;
		this.item = item;
		this.category = category;

	}

	/**
	 * This method get the id when called.
	 * 
	 * @return id
	 */
	public UUID getId() {
		return this.id = id;
	}

	/**
	 * This method gets the date when called.
	 * 
	 * @return date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * This method set the date when called.
	 * 
	 * @param date to be set
	 */
	public void setDate(LocalDate date) {
		if (date == null) {
			throw new IllegalArgumentException("date cannot be null");
		}
		this.date = date;
	}

	/**
	 * This method get the amount when called.
	 * 
	 * @return amount
	 */
	public double getAmount() {
		return this.amount = amount;
	}

	/**
	 * This method set the amount when called.
	 * 
	 * @param amount to be set.
	 */
	public void setAmount(double amount) {
		if (amount < 0) {
			throw new IllegalArgumentException("amount cannot be less than zero");
		}

		this.amount = amount;
	}

	/**
	 * This method get the merchant when called
	 * 
	 * @return merchant
	 */
	public String getMerchant() {
		return this.merchant = merchant;
	}

	/**
	 * This method set merchant when called.
	 * 
	 * @param merchant to be set
	 */
	public void setMerchant(String merchant) {
		if (merchant == null || merchant.isEmpty()) {
			throw new IllegalArgumentException("Merchant cannot be null");
		}

		this.merchant = merchant;
	}

	/**
	 * This method get the item when called.
	 * 
	 * @return item
	 */
	public String getItem() {
		return this.item = item;
	}

	/**
	 * This method set the value of the item when called.
	 * 
	 * @param item to be set
	 */
	public void setItem(String item) {
		if (item == null) {
			throw new IllegalArgumentException("Item cannot be null");
		}

		this.item = item;
	}

	/**
	 * This method get the category when called.
	 * 
	 * @return category
	 */
	public Category getCategory() {
		return this.category = category;
	}

	/**
	 * This method set the category when called.
	 * 
	 * @param category to be set
	 */
	public void setCategory(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("category cannot be null");
		}

		this.category = category;

	}

	@Override
	public String toString() {
		return this.date + ", " + this.amount + ", " + this.category + ", " + this.item;
	}

	@Override
	public int compareTo(Expense expense) {
		return expense.getDate().compareTo(this.date);
	}

}
