package com.github.markozajc.functions;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes a primitive byte, and returns a generic
 * type.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface ByteFunction<R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param value
	 *            value the function argument
	 *
	 * @return the function result
	 */
	R apply(byte value);

}
