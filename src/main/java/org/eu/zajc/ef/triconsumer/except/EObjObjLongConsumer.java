package org.eu.zajc.ef.triconsumer.except;

import static org.eu.zajc.ef.Utilities.asUnchecked;

import org.eu.zajc.ef.triconsumer.ObjObjLongConsumer;

/**
 * Variant of {@link ObjObjLongConsumer} capable of throwing a generic
 * {@link Throwable}.
 *
 * @author Marko Zajc
 *
 * @param <T>
 *            the type of the first argument to the operation
 * @param <U>
 *            the type of the second argument to the operation
 * @param <E>
 *            {@link Throwable} type
 */
@FunctionalInterface
public interface EObjObjLongConsumer<T, U, E extends Throwable> extends ObjObjLongConsumer<T, U> {

	@Override
	default void accept(T t, U u, long p) {
		try {
			acceptChecked(t, u, p);
		} catch (Throwable e) { // NOSONAR can't catch generic exceptions
			throw asUnchecked(e);
		}
	}

	/**
	 * Same as {@link #accept(Object, Object, long)}, but throws a checked exception.
	 *
	 * @param t
	 *            the first input argument
	 * @param u
	 *            the second input argument
	 * @param p
	 *            the third ({$code long})input argument
	 *
	 * @throws E
	 *             the defined exception type
	 */
	void acceptChecked(T t, U u, long p) throws E;

}
