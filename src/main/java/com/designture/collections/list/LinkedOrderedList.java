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
 * Implements an orderred list, using a linked list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class LinkedOrderedList<T> extends LinkedList<T> implements OrderedListADT<T>
{

	/**
	 * Adds the specified element to this list at the proper location
	 *
	 * @param element the element to be added to this list
	 */
	@Override
	public void add(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		LinearNode<T> cur = this.front.getNext();
		LinearNode<T> prev = this.front;

		// Creates a temporary compator
		Comparable<T> comp = (Comparable<T>) element;

		// Scrolls the list to the position where the element will be inserted
		while (cur.getNext() != null) {
			if (comp.compareTo(cur.getValue()) >= 0) {
				prev = cur;
				cur = cur.getNext();
			} else {
				break;
			}
		}

		// Adds the element
		newNode.setNext(cur);
		prev.setNext(newNode);

		// Increments the count
		this.count++;
	}
	
}
