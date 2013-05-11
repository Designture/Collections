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
 * This exception indicates that the collection is empty.
 *
 * @author Gil Mendes (gil0mendes) - <gil00mendes@gmail.com>
 */
public class EmptyCollectionException extends Exception
{

	public EmptyCollectionException()
	{
	}

	public EmptyCollectionException(String message)
	{
		super(message);
	}

	public EmptyCollectionException(Throwable cause)
	{
		super(cause);
	}

	public EmptyCollectionException(String message, Throwable cause)
	{
		super(message, cause);
	}
}
