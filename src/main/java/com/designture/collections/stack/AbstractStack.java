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
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public abstract class AbstractStack<T> implements Stack<T>
{

	/**
	 * Sole constructor.
	 */
	public AbstractStack()
	{
		super();
	}

	/**
	 * Adds the specified to the top of this stack.
	 *
	 * @param element generic element to be pushed onto stack
	 */
	@Override
	public void push(T element)
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes the element at the top of this stack and returns a reference to
	 * it.
	 *
	 * @return element removed from top of stack
	 * @throws EmptyCollectionException if pop is attempted on empty stack
	 */
	@Override
	public T pop() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns a refrerence to the element at the top of this stack.
	 *
	 * The element is not removed from stack.
	 *
	 * @return element on top of stack
	 * @throws EmptyCollectionException if a peek is attempted on empty stack
	 */
	@Override
	public T peek() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Retruns true if this stack contains no elements
	 *
	 * @return whether or not this stack is empty
	 */
	@Override
	public boolean isEmpty()
	{
		return (this.size() == 0);
	}

	/**
	 * Retruns the number of elements in this stack
	 *
	 * @return number of elements in this stack
	 */
	@Override
	public int size()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear()
	{
		throw new UnsupportedOperationException();
	}

}
