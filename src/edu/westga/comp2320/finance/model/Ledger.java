package edu.westga.comp2320.finance.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents collection of expenses.
 * 
 * @author Deeksha Namani
 * @version 11/21/2023
 */
public class Ledger implements Collection<Expense> {
	// The Ledger will use a HashMap internally to store the expenses. Assuming each
	// expense has a unique identifier, the HashMap could be of the form
	// HashMap<IdType, Expense>.
	private Map<UUID, Expense> expenses;

	/**
	 * This constructor initialize a ledger object
	 */
	public Ledger() {
		this.expenses = new HashMap<>();
	}

	/**
	 * Returns the number of expenses in the ledger.
	 * 
	 * @return size of ledger
	 */
	@Override
	public int size() {
		return this.expenses.size();
	}

	/**
	 * Checks if the ledger is empty (no expenses).
	 * 
	 * @return true if empty
	 */
	@Override
	public boolean isEmpty() {
		return this.expenses.isEmpty();
	}

	/**
	 * Checks if a specific expense is in the ledger. This requires either
	 * overriding equals in Expense or casting and checking manually.
	 */
	@Override
	public boolean contains(Object object) {
		if (object instanceof Expense) {
			Expense expense = (Expense) object;
			return this.expenses.containsKey(expense.getId());
		}
		return false;
	}

	/**
	 * Returns an iterator over the expenses in the ledger.
	 * 
	 * @return iterator
	 */
	@Override
	public Iterator<Expense> iterator() {
		return this.expenses.values().iterator();
	}

	/**
	 * Converts the expenses to an array.
	 * 
	 * @return array
	 */
	@Override
	public Object[] toArray() {
		return this.expenses.values().toArray();
	}

	/**
	 * Converts the collection to an array of a specific runtime type.
	 * 
	 * @return
	 */
	@Override
	public <T> T[] toArray(T[] collection) {
		return this.expenses.values().toArray(collection);
	}

	/**
	 * Adds an expense to the ledger. Generates a new UUID for each new expense.
	 * 
	 * @return true if added
	 */
	@Override
	public boolean add(Expense expense) {
		if (expense == null) {
			throw new IllegalArgumentException("Expense cannot be null.");
		}
		this.expenses.put(expense.getId(), expense);
		return true;
	}

	/**
	 * Removes a single instance of the specified element from the ledger, if it is
	 * present.
	 * 
	 * @return true after removing or false if not
	 */
	@Override
	public boolean remove(Object object) {
		if (object instanceof Expense) {
			Expense expense = (Expense) object;
			return this.expenses.remove(expense.getId()) != null;
		}
		return false;
	}

	/**
	 * Checks if the ledger contains all elements in the specified collection.
	 * 
	 * @return true if found or false
	 */
	@Override
	public boolean containsAll(Collection<?> collection) {
		for (Object object : collection) {
			if (!this.contains(object)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Adds all of the elements in the specified collection to the ledger.
	 * 
	 * @return modified
	 */
	@Override
	public boolean addAll(Collection<? extends Expense> collection) {
		boolean modified = false;
		for (Expense expense : collection) {
			if (this.add(expense)) {
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Removes all of the ledger's elements that are also contained in the specified
	 * collection.
	 * 
	 * @return modified
	 */
	@Override
	public boolean removeAll(Collection<?> collection) {
		boolean modified = false;
		for (Object object : collection) {
			if (this.remove(object)) {
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Retains only the elements in the ledger that are contained in the specified
	 * collection.
	 * 
	 * @return modified
	 */
	@Override
	public boolean retainAll(Collection<?> collection) {
		boolean modified = false;
		Set<UUID> keys = new HashMap<>(this.expenses).keySet();
		for (UUID key : keys) {
			if (!collection.contains(this.expenses.get(key))) {
				this.expenses.remove(key);
				modified = true;
			}
		}
		return modified;
	}

	/**
	 * Clears all expenses from the ledger.
	 */
	@Override
	public void clear() {
		this.expenses.clear();
	}

	/**
	 * Checks if the ledger elements and expenses are matched
	 * 
	 * @return if equals or not
	 */
	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof Ledger)) {
			return false;
		}
		Ledger ledger = (Ledger) object;
		return this.expenses.equals(ledger.expenses);
	}

	/**
	 * Returns the hashCode
	 * 
	 * @return hashCode
	 */
	@Override
	public int hashCode() {
		return this.expenses.hashCode();
	}

	/**
	 * Get total amount by category.
	 * 
	 * @precondition category != null
	 * @postcondition none
	 * @param category the specified category
	 * @return total amount in category
	 */
	public double getTotal(Category category) {
		if (category == null) {
			throw new IllegalArgumentException("Category cannot be null.");
		}
		double total = 0.0;
		for (Expense expense : this.expenses.values()) {
			if (expense.getCategory() == category) {
				total += expense.getAmount();
			}
		}
		return total;
	}

	/**
	 * Sort expenses by Date.
	 * 
	 * @precondition none
	 * @postcondition expenses sorted by Date.
	 */
	public void sortByDate() {
		List<Map.Entry<UUID, Expense>> list = new ArrayList<>(this.expenses.entrySet());
		list.sort(Map.Entry.comparingByValue());

		LinkedHashMap<UUID, Expense> sortedMap = new LinkedHashMap<>();
		for (Map.Entry<UUID, Expense> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}
		this.expenses = sortedMap;
	}

}
