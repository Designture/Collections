/*
 * This file is part of the Designture project.
 * 
 * Copyrigth (c) 2012-2013 Designture. All Rights reserved.
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.designture.collections.list;

/**
 * This interface represents an ordered list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public interface OrderedListADT<T> extends List<T>
{
	/**
	 * Adds the specified element to this list at the proper location
	 *
	 * @param element The element to be added to this list
	 */
	public void add(T element);
}
