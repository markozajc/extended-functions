package com.github.markozajc.ef.function;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes a primitive short, and returns a generic
 * type.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface ShortFunction<R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param value
	 *            value the function argument
	 *
	 * @return the function result
	 */
	R apply(short value);

}
