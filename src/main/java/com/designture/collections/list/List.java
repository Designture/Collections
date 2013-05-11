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
 * This interface represents a list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public interface List<T> extends Iterable<T>
{
	/**
	 * Removes and returns the first element from this list.
	 *
	 * @return the first element from this list
	 */
	public T removeFirst() throws EmptyCollectionException;

	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return the last element from this list
	 */
	public T removeLast() throws EmptyCollectionException;

	/**
	 * Removes and returns the specified element from this list.
	 *
	 * @param element the element to be removed from the list
	 */
	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException;

	/**
	 * Returns a reference to the first element in this list.
	 *
	 * @return a reference to the first element in this list
	 */
	public T first() throws EmptyCollectionException;

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 */
	public T last() throws EmptyCollectionException;

	/**
	 * Returns true if this list contains the specified target element.
	 *
	 * @param target the target that is being sought in the list
	 * @return true if the list contains this element
	 */
	public boolean contains(T target) throws EmptyCollectionException;

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the integer representation of number of elements in this list
	 */
	public int size();
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear();

	/**
	 * Returns an iterator for the elements in this list.
	 *
	 * @return an iterator over the elements in this list
	 */
	public Iterator<T> iterator();

	/**
	 * Returns a string representation of this list.
	 *
	 * @return a string representation of this list
	 */
	@Override
	public String toString();
}
