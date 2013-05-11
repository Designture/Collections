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

/**
 * This interface requests a stack
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public interface Stack<T>
{

	/**
	 * Adds one element to the top of this stack.
	 *
	 * @param element element to be pushed onto stack.
	 */
	public void push(T element);

	/**
	 * Removes and returns the top element from this stack.
	 *
	 * @return T Element removed from the top of the stack.
	 */
	public T pop() throws EmptyCollectionException;

	/**
	 * Returns without removing the top element of this stack.
	 *
	 * @return T element on top of the stack
	 */
	public T peek() throws EmptyCollectionException;

	/**
	 * Returns true if this stack contains no elements.
	 *
	 * @return boolean whether or not this stack is empty.
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this stack.
	 *
	 * @return int number of elements in this stack.
	 */
	public int size();

	/**
	 * Removes all of the elements from this list.
	 */
	public void clear();

	/**
	 * Returns a string representation of this stack.
	 *
	 * @return String representation of this stack
	 */
	@Override
	public String toString();
}
