package com.github.markozajc.ef.biconsumer.except;

import static com.github.markozajc.ef.Utilities.asUnchecked;

import com.github.markozajc.ef.biconsumer.ObjShortConsumer;

/**
 * Variant of {@link ObjShortConsumer} capable of throwing a generic
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
public interface EObjShortConsumer<T, E extends Throwable> extends ObjShortConsumer<T> {

	@Override
	default void accept(T t, short p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, short)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code short})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, short p) throws E;

}
