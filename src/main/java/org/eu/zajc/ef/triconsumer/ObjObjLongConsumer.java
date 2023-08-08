package org.eu.zajc.ef.triconsumer;

/**
 * A {@link TriConsumer} variant that takes two generic types and a primitive long.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface ObjObjLongConsumer<T, U> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({@code long}) input argument
	 */
	void accept(T t, U u, long p);

}
