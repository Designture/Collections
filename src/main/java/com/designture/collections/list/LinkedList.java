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
 * This class implements a linked list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class LinkedList<T> extends AbstractList<T>
{
	protected LinearNode<T> front;

	/**
	 * Creates an instance of this class and creates sentinel nodes
	 */
	public LinkedList()
	{
		this.front = new LinearNode<T>();
		this.front.setNext(new LinearNode());
	}

	/**
	 * Removes and returns the first element from this list.
	 *
	 * @return the first element from this list
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public T removeFirst() throws EmptyCollectionException {
		// Checks if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			LinearNode<T> toRemove = this.front.getNext();

			// Remove the node from the list
			this.front.setNext(toRemove.getNext());

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
	public T removeLast() throws EmptyCollectionException {
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			LinearNode<T> cur = this.front.getNext();
			LinearNode<T> prev = this.front;
			
			// Scroll through the list until the end
			while(cur.getNext() != null) {
				prev = cur;
				cur = cur.getNext();
			}
			
			// Remove the node from the list
			prev.setNext(cur.getNext());

			// Decrements the count
			this.count--;

			// Returns the value stored by node removed
			return cur.getValue();
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
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException {
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			LinearNode<T> cur = this.front.getNext();
			LinearNode<T> prev = this.front;

			// Scroll through the list until you find the element or the end
			while (cur.getNext() != null && !element.equals(cur.getValue())) {
				prev = cur;
				cur = cur.getNext();
			}

			// Checks if the element is the same of requested
			if (!element.equals(cur.getValue())) {
				throw new ElementNotFoundException("Not Found");
			}

			// Remove the node from the list
			prev.setNext(cur.getNext());

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
	public T first() throws EmptyCollectionException {
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			return (T)(this.front.getNext().getValue());
		}
	}

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 * @throws EmptyCollectionException Indicates that the list is empty
	 */
	@Override
	public T last() throws EmptyCollectionException {
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			LinearNode<T> cur = this.front.getNext();
			
			// Scroll through the list until the end
			while(cur.getNext().getNext() != null) {
				cur = cur.getNext();
			}
			
			return cur.getValue();
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
	public boolean contains(T target) throws EmptyCollectionException {
		// Check if the list is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			LinearNode<T> cur = this.front.getNext();

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

	@Override
	public Iterator<T> iterator()
	{
		return new DoubleLinkedListIterator<T>(this);
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear()
	{
		super.clear();
		this.front = new LinearNode<T>();
		this.front.setNext(new LinearNode());
	}
	
	/**
	 * Returns a string representation of this list.
	 *
	 * @return a string representation of this list
	 */
	@Override
	public String toString() {
		String out = "";
		LinearNode<T> cur = this.front.getNext();

		while (cur.getNext() != null) {
			out += cur.getValue();

			if (cur.getNext().getNext() != null) {
				out += ";";
			}

			cur = cur.getNext();
		}

		return out;
	}
	
	private class DoubleLinkedListIterator<T> implements Iterator<T> {

		private LinearNode<T> cur = null;
		private LinearNode<T> prev = null;
		LinkedList<T> l;

		public DoubleLinkedListIterator(LinkedList l) {
			cur = (LinearNode<T>) LinkedList.this.front.getNext();
			prev = (LinearNode<T>) LinkedList.this.front;
			this.l = l;
		}

		@Override
		public boolean hasNext() {
			return (cur.getNext() == null) ? false : true;
		}

		@Override
		public T next() {
			T forReturn = cur.getValue();

			prev = cur;
			cur = cur.getNext();

			return forReturn;
		}

		@Override
		public void remove() {
			try {
				l.remove(prev.getValue());
			} catch (Exception ex) {
			}
		}
	}
	
}
