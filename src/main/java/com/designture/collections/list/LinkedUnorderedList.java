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
 * Implements an unordered list, using a linked list
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class LinkedUnorderedList<T> extends LinkedList<T> implements UnorderedList<T>
{

	/**
	 * Adds a new element at the beginning of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToFront(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);

		// Adds the new node
		newNode.setNext(this.front.getNext());
		this.front.setNext(newNode);

		// Increments the count
		this.count++;
	}

	/**
	 * Adds a new element at the end of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToRear(T element)
	{
		LinearNode<T> newNode = new LinearNode<T>(element);
		LinearNode<T> cur = this.front.getNext();
		LinearNode<T> prev = this.front;

		// Scrolls the list to the position where the element will be inserted
		while (cur.getNext() != null) {
			prev = cur;
			cur = cur.getNext();
		}

		// Adds the new Node
		newNode.setNext(prev.getNext());
		prev.setNext(newNode);

		// Increments the count
		this.count++;
	}

	/**
	 * Adds a new element after another already inserted in the list.
	 *
	 * @param element The element to be added to this list
	 * @param target Target element
	 */
	@Override
	public void addAfter(T element, T target) throws ElementNotFoundException
	{
		LinearNode<T> newNode = new LinearNode<T>(element);
		LinearNode<T> cur = this.front.getNext();

		// Creates a temporary compator
		Comparable<T> comp = (Comparable<T>) target;

		// Search for target
		while (cur.getNext() != null && !comp.equals(cur.getValue())) {
			cur = cur.getNext();
		}

		// If the target is not found
		if (!cur.getValue().equals(target)) {
			throw new ElementNotFoundException("Not found");
		}

		// Adds the new Node
		newNode.setNext(cur.getNext());
		cur.setNext(newNode);

		// Increments the count
		this.count++;
	}
}
