/*
 * This file is part of the Designture project.
 * 
 * Copyrigth (c) 2012-2013 Designture. All Rights reserved.
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.designture.collections.stack;

import com.designture.collections.exception.EmptyCollectionException;
import com.designture.collections.list.LinkedUnorderedList;

/**
 * This class implements a stack using a <tt>{@link LinkedUnorderedList}</tt>.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class LinkedStack<T> extends AbstractStack<T>
{
	protected LinkedUnorderedList<T> list;

	/**
	 * Creates an empty stack
	 */
	public LinkedStack()
	{
		this.list = new LinkedUnorderedList<T>();
	}

	/**
	 * Adds one element to the top of this stack
	 * 
	 * @param element element to be pushed onto stack
	 */
	@Override
	public void push(T element)
	{
		// Adds the new element
		this.list.addToFront(element);
	}

	/**
	 * Adds one element to the top of this stack.
	 * 
	 * @return element to be pushed onto stack
	 * @throws EmptyCollectionException if the colection is empty
	 */
	@Override
	public T pop() throws EmptyCollectionException
	{
		// Remove the frist element and return
		return this.list.removeFirst();
	}

	/**
	 * Returns without removing the pop element of this stack.
	 * 
	 * @return element on top of the stack
	 * @throws EmptyCollectionException if the operation is empty
	 */
	@Override
	public T peek() throws EmptyCollectionException
	{
		// Return the frist element without remove
		return this.list.first();
	}

	/**
	 * Returns tru if this stack contains no elements.
	 * 
	 * @return whether or not this stack is empty
	 */
	@Override
	public boolean isEmpty()
	{
		return this.list.isEmpty();
	}

	/**
	 * Returns the number of elements in this stack
	 * 
	 * @return number of elements in this stack
	 */
	@Override
	public int size()
	{
		return this.list.size();
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear()
	{
		this.list.clear();
	}

	/**
	 * Returns a string representation of this stack
	 * 
	 * @return representation of this stack
	 */
	@Override
	public String toString()
	{
		return this.list.toString();
	}
	
	

}
