package com.github.markozajc.ef.biconsumer;

import java.util.function.BiConsumer;

/**
 * A {@link BiConsumer} variant that takes a generic type and a primitive boolean.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface ObjBooleanConsumer<T> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({@code boolean}) input argument
	 */
	void accept(T t, boolean p);

}
