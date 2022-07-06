package com.github.markozajc.ef.biconsumer.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import java.util.function.ObjLongConsumer;

/**
 * Variant of {@link ObjLongConsumer} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjLongConsumer<T, E extends Throwable> extends ObjLongConsumer<T> {

	@Override
	default void accept(T t, long p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, long)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code long})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, long p) throws E;

}
