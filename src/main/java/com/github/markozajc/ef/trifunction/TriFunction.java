package com.github.markozajc.ef.trifunction;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes three generic types, and returns a generic
 * type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <V>
 *            the type of the third argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface TriFunction<T, U, V, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 * @param v
	 *            the third function argument
	 *
	 * @return the function result
	 */
	R apply(T t, U u, V v);

}
