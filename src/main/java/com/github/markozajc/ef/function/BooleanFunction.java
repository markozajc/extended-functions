package com.github.markozajc.ef.function;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes a primitive boolean, and returns a generic
 * type.
 *
 * @author Marko Zajc
 *
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface BooleanFunction<R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param p
	 *            value the function argument
	 *
	 * @return the function result
	 */
	R apply(boolean p);

}
