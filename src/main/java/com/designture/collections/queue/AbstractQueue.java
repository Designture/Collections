/*
 * This file is part of the Designture project.
 * 
 * Copyrigth (c) 2012-2013 Designture. All Rights reserved.
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.designture.collections.queue;

import com.designture.collections.exception.EmptyCollectionException;

/**
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public abstract class AbstractQueue<T> implements Queue<T>
{

	/**
	 * A sole constructor
	 */
	public AbstractQueue()
	{
	}

	/**
	 * Adds one element to the rear of this queue.
	 *
	 * @param element the element to be added to the rear of this queue
	 */
	@Override
	public void enqueue(T element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes and returns the element at the front of this queue.
	 *
	 * @return the element at the front of this queue
	 */
	@Override
	public T dequeue() throws EmptyCollectionException {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns without removing the element at the front of this queue.
	 *
	 * @return the first element in this queue
	 */
	@Override
	public T first() throws EmptyCollectionException {
		throw  new UnsupportedOperationException();
	}

	/**
	 *
	 * Returns true if this queue contains no elements.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return the integer representation of the size of this queue
	 */
	@Override
	public int size() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Clean all queue. Remove all elements presents in this collection.
	 */
	@Override
	public void clear()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the string representation of this queue
	 */
	@Override
	public String toString() {
		throw new UnsupportedOperationException();
	}
	
}
