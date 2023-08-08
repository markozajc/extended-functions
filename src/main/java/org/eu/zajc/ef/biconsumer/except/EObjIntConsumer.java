package org.eu.zajc.ef.biconsumer.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import java.util.function.ObjIntConsumer;

/**
 * Variant of {@link ObjIntConsumer} capable of throwing a generic {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjIntConsumer<T, E extends Throwable> extends ObjIntConsumer<T> {

	@Override
	default void accept(T t, int p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, int)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code int})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, int p) throws E;

}
