package com.github.markozajc.ef.function;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes a generic type and a primitive integer, and
 * returns a generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface ObjIntFunction<T, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param p
	 *            the second ({@code int}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, int p);

}
