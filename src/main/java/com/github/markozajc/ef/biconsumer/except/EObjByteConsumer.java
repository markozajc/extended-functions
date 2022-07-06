package com.github.markozajc.ef.biconsumer.except;

import static com.github.markozajc.ef.EFUtils.asUnchecked;

import com.github.markozajc.ef.biconsumer.ObjByteConsumer;

/**
 * Variant of {@link ObjByteConsumer} capable of throwing a generic
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
public interface EObjByteConsumer<T, E extends Throwable> extends ObjByteConsumer<T> {

	@Override
	default void accept(T t, byte p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, byte)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code byte})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, byte p) throws E;

}
