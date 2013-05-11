/*
 * This file is part of the Designture project.
 * 
 * Copyrigth (c) 2012-2013 Designture. All Rights reserved.
 * 
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */
package com.designture.collections.exception;

/**
 * This exception indicates that the element does not exist in the collection.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class ElementNotFoundException extends Exception
{

	public ElementNotFoundException()
	{
	}

	public ElementNotFoundException(String message)
	{
		super(message);
	}

	public ElementNotFoundException(Throwable cause)
	{
		super(cause);
	}

	public ElementNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
