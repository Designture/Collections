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
 * This class provides a skeletal implementation of the {@link List} interface
 * to minimize the offort required to implement this interface backed by a
 * "random access" data store (such as an array).
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public abstract class AbstractList<T> implements List<T>
{
	protected int count = 0;
	
	/**
	 * Sole constructor.
	 */
	protected AbstractList()
	{
		super();
	}

	@Override
	public T removeFirst() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T removeLast() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T first() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public T last() throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean contains(T target) throws EmptyCollectionException
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns true if this list no contains elements.
	 * 
	 * @return true if this list no contains elements
	 */
	@Override
	public boolean isEmpty()
	{
		return (this.size() == 0);
	}

	/**
	 * Returns the number f elements in this list.
	 * 
	 * @return the integer representation of number of elements in this list
	 */
	@Override
	public int size()
	{
		return this.count;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear()
	{
		this.count = 0;
	}

	@Override
	public Iterator<T> iterator()
	{
		throw new UnsupportedOperationException();
	}
}
