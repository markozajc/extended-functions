package com.github.markozajc.functions;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes two generic types and a primitive long, and
 * returns a generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <U>
 *            the type of the second argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface ObjObjLongFunction<T, U, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 * @param p
	 *            the third ({@code long}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, U u, long p);

}
