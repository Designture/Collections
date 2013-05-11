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
 * This class implements a node fot the implementation of linked
 * list.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class LinearNode<T>
{
	// A pointer to the node after this node
	protected LinearNode next;
	
	// The object contained within this node
	protected T value;

	/**
	 * Creates an empty node
	 */
	public LinearNode()
	{
		super();
		this.value = null;
		this.next = null;
	}
	
	/**
	 * Creates a node with a value and that the next points to null.
	 * 
	 * @param value value to be saved
	 */
	public LinearNode(T value) {
		super();
		this.value = null;
		this.next = null;
	}

	/**
	 * Creates a node completely filled
	 * 
	 * @param next value to be saved
	 * @param value reference to the next node
	 */
	public LinearNode(LinearNode next, T value)
	{
		super();
		this.next = next;
		this.value = value;
	}

	/**
	 * Gets the value stored bt the node
	 * 
	 * @return the value stored by the node
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
	 * @return reference to the next node
	 */
	public LinearNode getNext()
	{
		return next;
	}

	/**
	 * Sets the reference to the next node
	 * 
	 * @param next the reference to the next node
	 */
	public void setNext(LinearNode next)
	{
		this.next = next;
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
