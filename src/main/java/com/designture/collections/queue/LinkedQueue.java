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
import com.designture.collections.list.DoublyLinkedUnorderedList;
import com.designture.collections.list.UnorderedList;

/**
 * This class implements a queue using a <tt>{@link UnorderedList}</tt>.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class LinkedQueue<T> extends AbstractQueue<T>
{
	protected UnorderedList<T> list;
	
	//--------------------------------------------------------------------------
	// PUBLIC
	//--------------------------------------------------------------------------
	public LinkedQueue()
	{
		this.list = new DoublyLinkedUnorderedList<T>();
	}

	/**
	 * Adds one element to the rear of this queue
	 * 
	 * @param element the element to be added to the rear of this queue
	 */
	@Override
	public void enqueue(T element)
	{
		// Adds the element
		this.list.addToRear(element);
	}

	/**
	 * Removes and returns the element at the front of this queue.
	 * 
	 * @return the element at the front of this queue
	 * @throws EmptyCollectionException indicates that the queue is empty
	 */
	@Override
	public T dequeue() throws EmptyCollectionException
	{
		return this.list.removeFirst();
	}

	/**
	 * Returns without removing the element at the front of this queue
	 * 
	 * @return the frist element in this queue
	 @throws EmptyCollectionException indicates that the queue is empty
	 */
	@Override
	public T first() throws EmptyCollectionException
	{
		return this.list.first();
	}

	/**
	 * Returns the number of elements in this queue
	 * 
	 * @return the integer representation of the size of this queue
	 */
	@Override
	public int size()
	{
		return this.list.size();
	}

	/**
	 * Remove all elements of this queue
	 */
	@Override
	public void clear()
	{
		this.list.clear();
	}

	/**
	 * Returns a string representation of this queue.
	 * 
	 * @return the string representation of this queue
	 */
	@Override
	public String toString()
	{
		return this.list.toString();
	}
	
	
	

	
	
}
