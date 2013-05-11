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
import com.designture.collections.exception.EmptyCollectionException;
import java.util.Iterator;

/**
 * This class implements a doubly linked list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class DoublyLinkedList<T> extends AbstractList<T>
{

	protected BilinearNode<T> front;
	protected BilinearNode<T> rear;

	/**
	 * Creates an instance of this class and creates sentinel nodes
	 */
	public DoublyLinkedList()
	{
		this.front = new BilinearNode<T>();
		this.rear = new BilinearNode<T>();

		this.front.setNext(this.rear);
		this.rear.setPrev(this.front);
	}

	/**
	 * Removes and returns the first element from this list.
	 *
	 * @return the first element from this list
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public T removeFirst() throws EmptyCollectionException
	{
		// Checks if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			BilinearNode<T> toRemove = this.front.getNext();
			BilinearNode<T> nextOfRemove = toRemove.getNext();

			// Remove the node from the list
			this.front.setNext(nextOfRemove);
			nextOfRemove.setPrev(this.front);

			// Decrements the count
			this.count--;

			// Returns the value stored by node removed
			return toRemove.getValue();
		}
	}

	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return The last element fromt his list
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public T removeLast() throws EmptyCollectionException
	{
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			BilinearNode<T> toRemove = this.rear.getPrev();
			BilinearNode<T> prevOfRemove = toRemove.getPrev();

			// Remove the node from the list
			this.rear.setPrev(prevOfRemove);
			prevOfRemove.setNext(this.rear);

			// Decrements the count
			this.count--;

			// Returns the value stored by node removed
			return toRemove.getValue();
		}
	}

	/**
	 * Removes and returns the specified element from this list.
	 *
	 * @param element the element to be removed from the list
	 *
	 * @throws EmptyCollectionException Indicates that the list is empty
	 * @throws ElementNotFoundException Indicates that the element to be removed
	 * is not a part of the list
	 */
	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException
	{
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			BilinearNode<T> cur = this.front.getNext();

			// Scroll through the list until you find the element or the end
			while (cur.getNext() != null && !element.equals(cur.getValue())) {
				cur = cur.getNext();
			}

			// Checks if the element is the same of requested
			if (!element.equals(cur.getValue())) {
				throw new ElementNotFoundException("Not Found");
			}

			// Remove the node from the list
			cur.getPrev().setNext(cur.getNext());
			cur.getNext().setPrev(cur.getPrev());

			// Decrements the count
			this.count--;

			// Returns the value stored by node removed
			return cur.getValue();
		}
	}

	/**
	 * Returns a reference to the first element in this list.
	 *
	 * @return a reference to the first element in this list
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public T first() throws EmptyCollectionException
	{
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			return this.front.getNext().getValue();
		}
	}

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public T last() throws EmptyCollectionException
	{
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			return this.rear.getPrev().getValue();
		}
	}

	/**
	 * Returns true if this list contains the specified target element.
	 *
	 * @param target the target that is being sought in the list
	 * @return true if the list contains this element
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public boolean contains(T target) throws EmptyCollectionException
	{
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			BilinearNode<T> cur = this.front.getNext();

			// Scroll through the list until you find the element or the end
			while (cur.getNext() != null) {
				if (target.equals(cur.getValue())) {
					return true;
				} else {
					cur = cur.getNext();
				}
			}

			return false;
		}
	}

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	@Override
	public boolean isEmpty()
	{
		return (this.count == 0) ? true : false;
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the integer representation of number of elements in this list
	 */
	@Override
	public int size()
	{
		return this.count;
	}

	/**
	 * Returns an iterator for the elements in this list.
	 *
	 * @return an iterator over the elements in this list
	 */
	@Override
	public Iterator<T> iterator()
	{
		return new DoubleLinkedListIterator<T>(this);
	}

	@Override
	public void clear()
	{
		super.clear();
		this.front = new BilinearNode<T>();
		this.rear = new BilinearNode<T>();

		this.front.setNext(this.rear);
		this.rear.setPrev(this.front);
	}
	
	

	/**
	 * Returns a string representation of this list.
	 *
	 * @return a string representation of this list
	 */
	@Override
	public String toString()
	{
		String out = "";
		BilinearNode<T> cur = this.front.getNext();

		while (cur.getNext() != null) {
			out += cur.getValue();

			if (cur.getNext() != this.rear) {
				out += ";";
			}

			cur = cur.getNext();
		}

		return out;
	}

	protected class DoubleLinkedListIterator<T> implements Iterator<T>
	{

		private BilinearNode<T> cur = null;
		DoublyLinkedList<T> l;

		public DoubleLinkedListIterator(DoublyLinkedList l)
		{
			cur = (BilinearNode<T>) DoublyLinkedList.this.front.getNext();
			this.l = l;
		}

		@Override
		public boolean hasNext()
		{
			return (cur.getNext() == null) ? false : true;
		}

		@Override
		public T next()
		{
			T forReturn = cur.getValue();

			cur = cur.getNext();

			return forReturn;
		}

		@Override
		public void remove()
		{
			try {
				l.remove(cur.getPrev().getValue());
			} catch (Exception ex) {
			}
		}
	}
}
