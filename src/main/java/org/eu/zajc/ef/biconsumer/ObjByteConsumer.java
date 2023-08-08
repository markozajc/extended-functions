package org.eu.zajc.ef.biconsumer;

import java.util.function.BiConsumer;

/**
 * A {@link BiConsumer} variant that takes a generic type and a primitive byte.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface ObjByteConsumer<T> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({@code byte}) input argument
	 */
	void accept(T t, byte p);

}
