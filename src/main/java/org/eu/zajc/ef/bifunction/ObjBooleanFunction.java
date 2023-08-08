package org.eu.zajc.ef.bifunction;

import java.util.function.BiFunction;

/**
 * A {@link BiFunction} variant that takes a generic type and a primitive boolean,
 * and returns a generic type.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the function
 * @param <R>
 *            the type of the result of the function
 */
@FunctionalInterface
public interface ObjBooleanFunction<T, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param p
	 *            the second ({@code boolean}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, boolean p);

}
