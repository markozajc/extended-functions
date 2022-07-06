package com.github.markozajc.ef.bifunction;

import java.util.function.BiFunction;

/**
 * A {@link BiFunction} variant that takes a generic type and a primitive short, and
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
public interface ObjShortFunction<T, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param p
	 *            the second ({@code short}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, short p);

}
