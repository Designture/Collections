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
 * Implements an unordered list, using a doubly linked list
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class DoublyLinkedUnorderedList<T> extends DoublyLinkedList<T> implements UnorderedList<T>
{

	/**
	 * Adds a new element at the beginning of the list.
	 *
	 * @param element The element to be added to this list
	 */
	@Override
	public void addToFront(T element)
	{
		BilinearNode<T> newNode = new BilinearNode<T>(element);

		// Adds the new node
		newNode.setNext(this.front.getNext());
		newNode.setPrev(this.front);
		this.front.getNext().setPrev(newNode);
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
		BilinearNode<T> newNode = new BilinearNode<T>(element);

		// Adds the new Node
		newNode.setNext(this.rear);
		newNode.setPrev(this.rear.getPrev());
		this.rear.getPrev().setNext(newNode);
		this.rear.setPrev(newNode);

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
		BilinearNode<T> newNode = new BilinearNode<T>(element);
		BilinearNode<T> cur = this.front.getNext();

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
		newNode.setPrev(cur);
		cur.getNext().setPrev(newNode);
		cur.setNext(newNode);

		// Increments the count
		this.count++;
	}
}
