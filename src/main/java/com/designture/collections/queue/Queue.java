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
 * This interface represents a queue
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public interface Queue<T>
{
	/**
	 * Adds one element to the rear of this queue.
	 *
	 * @param element the element to be added to the rear of this queue
	 */
	public void enqueue(T element);

	/**
	 * Removes and returns the element at the front of this queue.
	 *
	 * @return the element at the front of this queue
	 */
	public T dequeue() throws EmptyCollectionException;

	/**
	 * Returns without removing the element at the front of this queue.
	 *
	 * @return the first element in this queue
	 */
	public T first() throws EmptyCollectionException;

	/**
	 *
	 * Returns true if this queue contains no elements.
	 *
	 * @return true if this queue is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return the integer representation of the size of this queue
	 */
	public int size();
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear();

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the string representation of this queue
	 */
	@Override
	public String toString();
}
