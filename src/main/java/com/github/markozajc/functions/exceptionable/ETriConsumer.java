package com.github.markozajc.functions.exceptionable;

import static com.github.markozajc.functions.exceptionable.Utilities.asUnchecked;

import com.github.markozajc.functions.TriConsumer;

/**
 * Variant of {@link TriConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <V>
 *            the type of the third argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface ETriConsumer<T, U, V, E extends Throwable> extends TriConsumer<T, U, V> {

	@Override
	default void accept(T t, U u, V v) {
		try {
			acceptChecked(t, u, v);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object, Object)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param v
	 *            the third input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u, V v) throws E;

}
