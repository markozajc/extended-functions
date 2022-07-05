package com.github.markozajc.ef.bifunction;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes a generic type and a primitive byte, and
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
public interface ObjByteFunction<T, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param p
	 *            the second ({@code byte}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, byte p);

}
