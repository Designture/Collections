/*
 * This file is part of the Designture project.
 * 
 * Copyrigth (c) 2012-2013 Designture. All Rights reserved.
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.designture.collections.list;

import com.designture.collections.exception.ElementNotFoundException;

/**
 * This class implements an unordered list that uses an array to implement.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class ArrayUnorderedList<T> extends ArrayList<T> implements UnorderedList<T>
{

	/**
	 * Adds a new element at the beginning of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToFront(T element) {
		// Checks if the size is sufficient, if not, the array expands
		if (this.rear == this.list.length) {
			this.ExpandeCapacity();
		}
		
		// Drag all elements above the position of the new element to the
		// side (+1)
		for (int index = this.rear; index > 0; index--) {
			this.list[index] = this.list[index - 1];
		}
		
		// Adds the element
		this.list[0] = element;
		
		// Increments the rear and the count
		this.rear++;
		this.count++;
	}

	/**
	 * Adds a new element at the end of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToRear(T element) {
		// Checks if the size is sufficient, if not, the array expands
		if (this.rear == this.list.length) {
			this.ExpandeCapacity();
		}
		
		// Adds the element
		this.list[this.rear] = element;
		
		// Increments the rear and the count
		this.rear++;
		this.count++;
	}

	/**
	 * Adds a new element after another already inserted in the list.
	 *
	 * @param element The element to be added to this list
	 * @param target Target element
	 */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException {
		// Checks if the size is sufficient, if not, the array expands
		if (this.rear == this.list.length) {
			this.ExpandeCapacity();
		}
		
		int scan;
		
		// Search for target
		for (scan = 0; scan < this.list.length; scan++) {
			if (this.list[scan].equals(target)) {
				break;
			}
		}
		
		// If the target is not found
		if (!target.equals(this.list[scan])) {
			throw  new ElementNotFoundException("Not found");
		} else {
			scan++;
		}
		
		// Drag all elements above the position of the new element to the side (+1)
		for (int index = this.rear; index > scan; index--) {
			this.list[index] = this.list[index - 1];
		}
		
		// Adds the element
		this.list[scan] = element;
		
		// Increments the rear and the count
		this.rear++;
		this.count++;
	}
	
}
