/*
 * This file is part of the Designture project.
 * 
 * Copyrigth (c) 2012-2013 Designture. All Rights reserved.
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.designture.collections.list;

/**
 * This class implements an ordered list that uses an array to implement.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class ArrayOrderedList<T> extends ArrayList<T> implements OrderedListADT<T>
{

	/**
	 * Adds the specified element to this list at the proper location
	 *
	 * @param element the element to be added to this list
	 */
	@Override
	public void add(T element) {
		// Checks if the size is sufficient, if not, the array expands
		if (this.rear == this.list.length) {
			this.ExpandeCapacity();
		}

		// Creates a temporary compator
		Comparable<T> comp = (Comparable<T>) element;

		// Checks can be inserted in the last position, without being necessary
		// to go through the whole list
		if (this.size() > 0 && comp.compareTo(this.list[this.rear - 1]) >= 0) {
			this.list[this.rear] = element;
		} else {
			// Scrolls the list to the position where the element will be
			// inserted
			int scan = 0;
			
			while (scan < (this.rear - 1) && comp.compareTo(this.list[scan]) > 0) {
				scan++;
			}
			
			// Drag all elements above the position of the new element to the
			// side (+1)
			for (int index = this.rear; index > scan; index--) {
				this.list[index] = this.list[index - 1];
			}
			
			// Adds the element
			this.list[scan] = element;
		}
		
		// Increments the rear and the count
		this.rear++;
		this.count++;
	}
	
}
