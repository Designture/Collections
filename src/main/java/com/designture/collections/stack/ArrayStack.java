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
 * This class implements a stack using a array
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class ArrayStack<T> extends AbstractStack<T>
{
	/**
	 * Constant to represent the default capacity os the array
	 */
	protected final int DEFAULT_CAPACITY = 10;
	
	/**
	 * int that representation both the number of elements and the next
	 * available position in the array
	 */
	protected int top;
	
	/**
	 * array of generic elements to represente the stack
	 */
	protected T[] stack;
	
	//--------------------------------------------------------------------------
	// PUBLIC
	//--------------------------------------------------------------------------
	
	/**
	 * Creates an empty stack using the default capacity
	 */
	public ArrayStack() {
		this.top = 0;
		this.stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}

	/**
	 * Creates an empty stack using the specified capacity.
	 *
	 * @param initialCapacity represents the specified capacity.
	 */
	public ArrayStack(int initialCapacity) {
		this.top = 0;
		this.stack = (T[]) (new Object[initialCapacity]);
	}

	/**
	 * Adds the specified to the top of this stack, expanding the capacity of
	 * the stack array if necessary.
	 *
	 * @param element Element generic element to be pushed onto stack
	 */
	@Override
	public void push(T element) {
		// Checks if the size is sufficient, if not, the array expands
		if (size() == stack.length) {
			expandCapacity();
		}
		
		// Adds the new element
		stack[top] = element;
		
		// Increments the top
		top++;
	}

	/**
	 * Removes the element at the top of this stack and returns a reference to
	 * it.
	 *
	 * Thows an EmptyCollectionException if the stack is empty.
	 *
	 * @return T element removed from top of stack
	 * @throws EmptyCollectionException if pop is attempted on empty stack
	 */
	@Override
	public T pop() throws EmptyCollectionException {
		// Checks if the stack is empty
		if (isEmpty()) {
			throw new EmptyCollectionException("Stack");
		}

		// Decrements the top
		this.top--;
		
		// Saves the value of the elemento to remove
		T result = this.stack[top];
		
		// Remove element from stack
		this.stack[top] = null;

		return result;
	}

	/**
	 * Returns a reference to the element at the top of this stack. The element
	 * is not removed from the stack. Throws an EmptyCollectionException if the
	 * stack is empty.
	 *
	 * @return T element on top of stack
	 * @throws EmptyCollectionException if a peek is attempted on empty stack
	 */
	@Override
	public T peek() throws EmptyCollectionException {
		// Checks if the stack is empty
		if (isEmpty()) {
			throw new EmptyCollectionException("Stack");
		}

		// Returns a reference to the element at the top if this stack.
		return this.stack[top - 1];
	}

	/**
	 * Returns true if this stack contains no elements.
	 *
	 * @return boolean whether or not this stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		return (this.top == 0) ? true : false;
	}

	/**
	 * Returns the number of elements in this stack.
	 *
	 * @return int number of elements in this stack.
	 */
	@Override
	public int size() {
		return this.top;
	}

	/**
	 * Removes all of the elements from this list.
	 */
	@Override
	public void clear()
	{
		super.clear();
		this.top = 0;
		this.stack = (T[]) (new Object[DEFAULT_CAPACITY]);
	}
	
	/**
	 * Returns a string representation of this stack.
	 *
	 * @return String representation of this stack
	 */
	@Override
	public String toString() {
		String result = "";
		boolean fristPass = true;
		
		for (int index = this.top-1; index >= 0; index--) {
			if (!fristPass) {
				result += ";";
			} else {
				fristPass = false;
			}
			
			result += this.stack[index];
		}
		
		return result;
	}
	
	//--------------------------------------------------------------------------
	// PRIVATE
	//--------------------------------------------------------------------------
	
	/**
	 * Expands the ability of the stack to double the current size.
	 */
	private void expandCapacity() {
		// Creates a new Stack, with double the current positions
		T[] newStack = (T[])(new Object[this.stack.length * 2]);
		
		// Copies data from the old to the new stack
		System.arraycopy(this.stack, 0, newStack, 0, this.size());
		
		// Replaces stack
		this.stack = newStack;
	}	
}
