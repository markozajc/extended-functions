package com.github.markozajc.ef.function;

import java.util.function.Function;

/**
 * A {@link Function} variant that takes two generic types and a primitive byte, and
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
public interface ObjObjByteFunction<T, U, R> {

	/**
	 * Applies this function to the given arguments.
	 *
	 * @param t
	 *            the first function argument
	 * @param u
	 *            the second function argument
	 * @param p
	 *            the third ({@code byte}) function argument
	 *
	 * @return the function result
	 */
	R apply(T t, U u, byte p);

}
