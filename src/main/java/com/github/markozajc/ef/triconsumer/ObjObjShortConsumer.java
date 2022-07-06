package com.github.markozajc.ef.triconsumer;

/**
 * A {@link TriConsumer} variant that takes two generic types and a primitive short.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 */
@FunctionalInterface
public interface ObjObjShortConsumer<T, U> {

	/**
	 * Performs this operation on the given arguments.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({@code short}) input argument
	 */
	void accept(T t, U u, short p);

}
