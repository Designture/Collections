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
 * This class implements a node for the implementation of doubly linked list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class BilinearNode<T>
{

	protected T value;
	protected BilinearNode<T> next;
	protected BilinearNode<T> prev;

	/**
	 * Creates an empty node
	 */
	public BilinearNode()
	{
		super();
		this.value = null;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * Creates a node with a value and that the next and previous points to null
	 *
	 * @param value Value to be saved
	 */
	public BilinearNode(T value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}

	/**
	 * Creates a node completely filled
	 *
	 * @param value value to be saved
	 * @param next reference to the previous node
	 * @param prev refrence to the next node
	 */
	public BilinearNode(T value, BilinearNode<T> next, BilinearNode<T> prev)
	{
		this.value = value;
		this.next = next;
		this.prev = prev;
	}

	/**
	 * Gets the value stored by the node
	 *
	 * @return the value
	 */
	public T getValue()
	{
		return value;
	}

	/**
	 * Sets a value to be stored by the node
	 *
	 * @param value the value to set
	 */
	public void setValue(T value)
	{
		this.value = value;
	}

	/**
	 * Gets a reference to the next node
	 *
	 * @return the next
	 */
	public BilinearNode<T> getNext()
	{
		return next;
	}

	/**
	 * Sets the reference to the next node
	 *
	 * @param next the next to set
	 */
	public void setNext(BilinearNode<T> next)
	{
		this.next = next;
	}

	/**
	 * Gets a reference to the previous node
	 *
	 * @return the prev
	 */
	public BilinearNode<T> getPrev()
	{
		return prev;
	}

	/**
	 * Sets the reference to the previous node
	 *
	 * @param prev the prev to set
	 */
	public void setPrev(BilinearNode<T> prev)
	{
		this.prev = prev;
	}

	/**
	 * String representation of the element stored at node
	 *
	 * @return
	 */
	@Override
	public String toString()
	{
		return "{value:" + this.value + "}";
	}
}
