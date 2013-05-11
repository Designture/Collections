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
 * This class implements a queue using a circular array
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class CircularArrayQueue<T> extends AbstractQueue<T>
{

	protected int front;
	protected int rear;
	protected int count;
	protected T[] queue;
	protected final int DEFAULT = 10;

	//--------------------------------------------------------------------------
	// PUBLIC
	//--------------------------------------------------------------------------
	/**
	 * Creates an instance of this class. The initial array has 20 positions.
	 */
	public CircularArrayQueue()
	{
		this.front = 0;
		this.rear = 0;
		this.count = 0;
		this.queue = (T[]) (new Object[this.DEFAULT]);
	}

	/**
	 * Creates an instance of this class.
	 *
	 * @param startPos Number of initial positions
	 */
	public CircularArrayQueue(int startPos)
	{
		this.front = 0;
		this.rear = 0;
		this.count = 0;
		this.queue = (T[]) (new Object[startPos]);
	}

	/**
	 * Adds one element to the rear of this queue.
	 *
	 * @param element the element to be added to the rear of this queue
	 */
	@Override
	public void enqueue(T element)
	{
		// Checks if the size is sufficient, if not, the array expands
		if (this.size() == this.queue.length) {
			this.ExpandeCapacity();
		}

		// Adds the element
		this.queue[this.rear] = element;

		// Recalculates the rear
		this.rear = (rear + 1) % queue.length;

		// Increments the count
		this.count++;
	}

	/**
	 * Removes and returns the element at the front of this queue.
	 *
	 * @return the element at the front of this queue
	 * @throws EmptyCollectionException Indicates that the queue is empty
	 */
	@Override
	public T dequeue() throws EmptyCollectionException
	{
		// Checks if the queue is empty
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			// Saves the value of the element to dequeue
			T tempValue = this.queue[this.front];

			// Remove the node from the list
			this.queue[this.front] = null;
			this.front++;

			// Recalculates the rear
			this.rear = (rear + 1) % queue.length;

			// Decrements the count
			this.count--;

			// Returns the value stored
			return tempValue;
		}
	}

	/**
	 * Returns without removing the element at the front of this queue.
	 *
	 * @return the first element in this queue
	 */
	@Override
	public T first() throws EmptyCollectionException
	{
		if (this.isEmpty()) {
			throw new EmptyCollectionException("Empty");
		} else {
			return this.queue[this.front];
		}
	}

	/**
	 *
	 * Returns true if this queue contains no elements.
	 *
	 * @return true if this queue is empty
	 */
	@Override
	public boolean isEmpty()
	{
		return (this.count == 0);
	}

	/**
	 * Returns the number of elements in this queue.
	 *
	 * @return the integer representation of the size of this queue
	 */
	@Override
	public int size()
	{
		return this.count;
	}

	/**
	 * Clean all queue. Remove all elements presents in this collection.
	 */
	@Override
	public void clear()
	{
		this.front = 0;
		this.rear = 0;
		this.count = 0;
		this.queue = (T[]) (new Object[this.DEFAULT]);
	}

	/**
	 * Returns a string representation of this queue.
	 *
	 * @return the string representation of this queue
	 */
	@Override
	public String toString()
	{
		String result = "{";
		boolean fristPass = true;

		for (int index = this.front, limit = this.count; limit != 0; limit--, index++) {
			if (!fristPass) {
				result += ";";
			} else {
				fristPass = false;
			}

			result += this.queue[index].toString();
		}

		return result + "}";
	}

	//--------------------------------------------------------------------------
	// PROTECTED
	//--------------------------------------------------------------------------
	/**
	 * Expands the ability of the queue to double the current size.
	 */
	protected void ExpandeCapacity()
	{
		// Creates a new queue, with double the current positions
		T[] newQueue = (T[]) (new Object[this.queue.length * 2]);

		// Copies data from the old to the new queue
		System.arraycopy(this.queue, 0, newQueue, 0, this.queue.length);

		this.front = 0;
		rear = this.count;

		// Replaces queue
		this.queue = newQueue;
	}
}
