package org.eu.zajc.ef.biconsumer;

import java.util.function.BiConsumer;

/**
 * A {@link BiConsumer} variant that takes a generic type and a primitive short.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 */
@FunctionalInterface
public interface ObjShortConsumer<T> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({@code short}) input argument
	 */
	void accept(T t, short p);

}
