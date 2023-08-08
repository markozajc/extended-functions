package org.eu.zajc.ef.biconsumer.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.biconsumer.ObjBooleanConsumer;

/**
 * Variant of {@link ObjBooleanConsumer} capable of throwing a generic
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
public interface EObjBooleanConsumer<T, E extends Throwable> extends ObjBooleanConsumer<T> {

	@Override
	default void accept(T t, boolean p) {
		try {
			acceptChecked(t, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, boolean)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param p
	 *            the second ({$code boolean})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, boolean p) throws E;

}
